 class Math4 {

    int answer;
    int Calculate (int operand1, int operand2, char sign){
         switch (sign){
             case '-': answer = operand1 - operand2;
             break;
             case '+': answer = operand1 + operand2;
             break;
             case '*': answer = operand1 * operand2;
             break;
             case '/': answer = operand1 / operand2;
             break;
             default:
         }
         return answer;
    }
}




