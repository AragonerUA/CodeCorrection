# How to run a solution?

1) Download the project from the GitHub
2) Add your OpenAI API Key in the file *openai_corrector.py* in the line:

  client = OpenAI(api_key="<YOUR_API_KEY>")

3) Write the next two commands in Terminal: 

  kotlinc <PATH_TO_TestTask.kt> -include-runtime -d <NAME_OF_JAR_FILE>.jar
  java -jar <NAME_OF_JAR_FILE>.jar <PATH_TO_THE_PYTHON_FILE_TO_BE_FIXED>

Here we are!

Example of usage with test file in the project:

<img width="1470" alt="Знімок екрана 2024-05-05 о 17 05 10" src="https://github.com/AragonerUA/CodeCorrection/assets/57654715/7ef68334-655b-4f6e-869b-662315535509">
<img width="460" alt="Знімок екрана 2024-05-05 о 17 09 00" src="https://github.com/AragonerUA/CodeCorrection/assets/57654715/bff0511c-e015-45fa-a97b-dba5295b98d2">
<img width="459" alt="Знімок екрана 2024-05-05 о 17 26 25" src="https://github.com/AragonerUA/CodeCorrection/assets/57654715/1f7b12ae-e686-4307-a98d-591da0a2a632">
