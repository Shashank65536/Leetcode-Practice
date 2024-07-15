public class Temp {

    public static void main(String[] args) {
        System.out.println(findMissingDigit("4x + 12 = 46")); // Output: 4
        System.out.println(findMissingDigit("1x0 + 12 = 120")); // Output: 1
    }

    public static int findMissingDigit(String equation) {
        // Split the equation into its parts
        String[] parts = equation.split(" ");
        int num = 0;int factor = 1;

        // Identify the positions of the numbers and the operator
        if (parts.length == 5) {
            String num1 = parts[0];
            String op = parts[1];
            String num2 = parts[2];
            String result = parts[4];

            if (num1.contains("x")) {
                int num2Int = Integer.parseInt(num2);
                int resultInt = Integer.parseInt(result);

                if(op.equals("+")){
                    int tempR = resultInt - num2Int;

                    for(char s: num1.toCharArray()){
                        if(s > '0' && s<'9'){
                            num = num * 10 + Integer.parseInt(String.valueOf(s));
                        }
                    }
                    return tempR/num;
                }

                //add  if cases for  - , / and * according to math
            } else if (num2.contains("x")) {
                int num1Int = Integer.parseInt(num1);
                int resultInt = Integer.parseInt(result);
                for (int i = 0; i < 10; i++) {
                    String num2Candidate = num2.replace('x', Character.forDigit(i, 10));
                    try {
                        if (op.equals("+")) {
                            if (num1Int + Integer.parseInt(num2Candidate) == resultInt) {
                                return i;
                            }
                        } else if (op.equals("-")) {
                            if (num1Int - Integer.parseInt(num2Candidate) == resultInt) {
                                return i;
                            }
                        } else if (op.equals("*")) {
                            if (num1Int * Integer.parseInt(num2Candidate) == resultInt) {
                                return i;
                            }
                        } else if (op.equals("/")) {
                            if (Integer.parseInt(num2Candidate) != 0 && num1Int / Integer.parseInt(num2Candidate) == resultInt) {
                                return i;
                            }
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            } else if (result.contains("x")) {
                int num1Int = Integer.parseInt(num1);
                int num2Int = Integer.parseInt(num2);
                for (int i = 0; i < 10; i++) {
                    String resultCandidate = result.replace('x', Character.forDigit(i, 10));
                    try {
                        if (op.equals("+")) {
                            if (num1Int + num2Int == Integer.parseInt(resultCandidate)) {
                                return i;
                            }
                        } else if (op.equals("-")) {
                            if (num1Int - num2Int == Integer.parseInt(resultCandidate)) {
                                return i;
                            }
                        } else if (op.equals("*")) {
                            if (num1Int * num2Int == Integer.parseInt(resultCandidate)) {
                                return i;
                            }
                        } else if (op.equals("/")) {
                            if (num2Int != 0 && num1Int / num2Int == Integer.parseInt(resultCandidate)) {
                                return i;
                            }
                        }
                    } catch (NumberFormatException e) {
                        continue;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
        return -1; // Return -1 if no solution is found
    }
}
