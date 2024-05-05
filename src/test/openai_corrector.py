import openai
from openai import OpenAI
import sys
import json

client = OpenAI(api_key="sk-proj-bNBTnuutLF22LHnbQ3S8T3BlbkFJwXLijJh9ZvHcg57Zd8Es")


def get_corrected_code(prompt):
    response = client.chat.completions.create(
        model="gpt-4",
        messages=[
            {
                "role": "system",
                "content": "You will be provided with a piece of Python code, and your task is to correct all the Syntax and Runtime errors."
                           "Please provide ONLY code without any explanations."
            },
            {
                "role": "user",
                "content": f"{prompt}"
            }
        ],
        temperature=0.3,
        max_tokens=500
    )
    corrected_code = response.choices[0].message.content.strip()
    return corrected_code


if __name__ == "__main__":
    prompt = ""
    for i in range(1, len(sys.argv)):
        prompt += sys.argv[i]

#     prompt = '''Fix the errors in the following Python code:
#     import math
# def division(a: int, b: int = 0) -> int:
#     result: float = a / b
#     return result
# }
#
# def summary(a: int, b: int) -> int:
#     result: int = a + b
#     return result;
#
# def subtraction(a: int, b: int) -> int:
#     result: int = a - b;
#     result -= 1;
#     return result;
# def main():
#     a: int = 1;
#     result_div: int = division(a)
#     b: float = 4.5;
#     result_sum: float = summary(a, b);
#     result_subt: float = subtraction(a, b);
#     print(result_div, result_sum, result_subt, sep="\n"
#         )
#     print(100/0)
# if __name__ == "__main__":
#     main();'''

    corrected_code = get_corrected_code(prompt)
    print(corrected_code)
