import math
def division(a: int, b: int = 0) -> int:
    result: float = a / b
    return result
}

def summary(a: int, b: int) -> int:
    result: int = a + b
    return result;

def subtraction(a: int, b: int) -> int:
    result: int = a - b;
    result -= 1;
    return result;
def main():
    a: int = 1;
    result_div: int = division(a)
    b: float = 4.5;
    result_sum: float = summary(a, b);
    result_subt: float = subtraction(a, b);
    print(result_div, result_sum, result_subt, sep="\n"
          )
    print(100/0)
if __name__ == "__main__":
    main();