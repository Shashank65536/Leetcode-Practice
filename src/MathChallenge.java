public class MathChallenge {

    public static void main(String[] args) {
        System.out.println(findMissingDigit("6x +    1 = 37")); // Output: 4
        System.out.println(findMissingDigit("1x0 + 12 = 120")); // Output: 1
    }

    public static int findMissingDigit(String equation) {
        // Split the equation into its parts
        String[] parts = equation.split(" ");
        int num = 0;
        int factor = 1;

        // Identify the positions of the numbers and the operator
        if (parts.length == 5) {
            String num1 = parts[0];
            String op = parts[1];
            String num2 = parts[2];
            String result = parts[4];

            if (num1.contains("x")) {
                int num2Int = Integer.parseInt(num2);
                int resultInt = Integer.parseInt(result);

                switch (op) {
                    case "+":
                        int tempR = resultInt - num2Int;
                        for (char s : num1.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "-":
                        tempR = resultInt + num2Int;
                        for (char s : num1.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "*":
                        tempR = resultInt / num2Int;
                        for (char s : num1.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "/":
                        tempR = resultInt * num2Int;
                        for (char s : num1.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                }
            } else if (num2.contains("x")) {
                int num1Int = Integer.parseInt(num1);
                int resultInt = Integer.parseInt(result);

                switch (op) {
                    case "+":
                        int tempR = resultInt - num1Int;
                        for (char s : num2.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "-":
                        tempR = num1Int - resultInt;
                        for (char s : num2.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "*":
                        tempR = resultInt / num1Int;
                        for (char s : num2.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "/":
                        tempR = num1Int / resultInt;
                        for (char s : num2.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                }
            } else if (result.contains("x")) {
                int num1Int = Integer.parseInt(num1);
                int num2Int = Integer.parseInt(num2);

                switch (op) {
                    case "+":
                        int tempR = num1Int + num2Int;
                        for (char s : result.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "-":
                        tempR = num1Int - num2Int;
                        for (char s : result.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "*":
                        tempR = num1Int * num2Int;
                        for (char s : result.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                    case "/":
                        tempR = num1Int / num2Int;
                        for (char s : result.toCharArray()) {
                            if (s >= '0' && s <= '9') {
                                num = num * 10 + Integer.parseInt(String.valueOf(s));
                            } else if (s == 'x') {
                                factor *= 10;
                            }
                        }
                        return tempR / num % 10;
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
        return -1; // Return -1 if no solution is found
    }
}
