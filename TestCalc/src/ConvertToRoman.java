import java.io.IOException;

class ConvertToRoman {
    String[] romanNumbersList1 = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] romanNumbersList2 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    String result;
    String Convert(int Num)  throws IOException {
        if(Num > 0){
            int Tens = Num / 10;
            int Edin = Num - ((Num / 10) * 10);
            String firstPart = romanNumbersList2[Tens];
            String secondPart = romanNumbersList1[Edin];
            result = firstPart + secondPart;
            return result;
        } else{
            throw new IOException();
        }
    }
}

