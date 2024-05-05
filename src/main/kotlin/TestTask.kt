import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader
//@SuppressWarnings("deprecated")

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("How to use: " +
                "kotlinc <path_to_this_file> -include-runtime -d *name_of_the_file*.jar" +
                "java -jar *name_of_the_file*.jar <path_to_python_file_that_must_be_corrected>")
        return
    }

    val filePath = args[0]
    val pythonCode = readPythonCode(filePath)

    var correctedCode = pythonCode
    while (true) {
        val errors = detectErrors(correctedCode)
        println()
        println()
        println("NUMBER OF ERRORS FOUND: ${errors.size}")
        if (errors.isEmpty()) {
            println()
            println("Corrected code:")
            println(correctedCode)
            break
        } else {
            println()
//            println("Inspecting the code:")
//            println(correctedCode)
            println("Errors found:")
            errors.forEach { println(it) }
            correctedCode = correctErrors(correctedCode)
        }
    }
}

fun readPythonCode(filePath: String): String {
    val file = File(filePath)
    return file.readText()
}

fun detectErrors(code: String): List<String> {
    val processBuilder = ProcessBuilder("python", "-m", "pyflakes")
    val process = processBuilder.start()

    process.outputStream.bufferedWriter().use { it.write(code) }
    process.outputStream.close()

    val reader = BufferedReader(InputStreamReader(process.errorStream))
    val errors = mutableListOf<String>()
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        errors.add(line!!)
    }
    return errors
}

fun sendToOpenAI(prompt: String): String {
//    val pythonScriptPath = "/Users/aragonerua/IdeaProjects/KotlinTestTask/src/test/openai_corrector.py"
    val pythonScriptPath = "src/test/openai_corrector.py"
    val command = "venv/bin/python3.10 $pythonScriptPath \"$prompt\""
//    val command = "/Users/aragonerua/IdeaProjects/KotlinTestTask/venv/bin/python3.10 $pythonScriptPath \"$prompt\""

    try {
        @Suppress("DEPRECATION")
        val process = Runtime.getRuntime().exec(command)
        process.waitFor()

        val reader = BufferedReader(InputStreamReader(process.inputStream))
        val correctedCode = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            correctedCode.append(line).append("\n")
        }
        return correctedCode.toString()
    } catch (e: Exception) {
        e.printStackTrace()
        return "Error: ${e.message}"
    }
}


fun correctErrors(code: String): String {
    print(code)
    return sendToOpenAI(code)
}