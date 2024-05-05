# How to run a solution?

1) Download the project from the GitHub
2) Add your OpenAI API Key in the file *openai_corrector.py* in the line:

  client = OpenAI(api_key="<YOUR_API_KEY>")

3) Write the next two commands in Terminal: 

  kotlinc <PATH_TO_TestTask.kt> -include-runtime -d <NAME_OF_JAR_FILE>.jar
  java -jar <NAME_OF_JAR_FILE>.jar <PATH_TO_THE_PYTHON_FILE_TO_BE_FIXED>

Here we are!
