import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main
{

    static String FileToGrab = "";
    static String FileToWrite = "";
    static String Key = "0000";
    static double TopLeftNum = 0;
    static double TopRightNum = 0;
    static double BottomLeftNum = 0;
    static double BottomRightNum = 0;
    static String whole = "";
    static double FpairNum = 0;
    static double SpairNum = 0;
    static double TopAnswer = 0;
    static double BottomAnswer = 0;
    static String OutputText = "";
    static String Choice = "";
    static int NumOfLetters = 29;

    //Grab the key, Turn it into 4 variables, Make sure its a valid Key, Make sure it is invertible
    static void GetKey()
    {

        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);


        double Det = 0;
        do{

            System.out.print("Please Enter a 4 Digit Key: ");
            Key = keyboard.next();

            while(Key.length() != 4 )
            {
                System.out.println("Error: Key Is Not Length 4");
                System.out.print("Please Enter a 4 Digit Key: ");
                Key = keyboard.next();
            }

            String TopLeft = Key.substring(0, 1);
            TopLeftNum = Double.parseDouble(TopLeft);
            String TopRight = Key.substring(1, 2);
            TopRightNum = Double.parseDouble(TopRight);
            String BottemLeft = Key.substring(2, 3);
            BottomLeftNum = Double.parseDouble(BottemLeft);
            String BottemRight = Key.substring(3, 4);
            BottomRightNum = Double.parseDouble(BottemRight);

            Det = (TopLeftNum * BottomRightNum)-(TopRightNum * BottomLeftNum);
            Det = Det % NumOfLetters;


            if(Det == 0)
            {
                System.out.println("Error: Determinant Equals 0");

            }

        }while(Key.length() != 4 || Det == 0 );

    }

    //Get the text from a File and put it into 1 variable.  Make sure it is an even number and if not change it to even.
    static void GetText() throws FileNotFoundException
    {

        Scanner ReadText = new Scanner(new FileInputStream(FileToGrab));

        while(ReadText.hasNext())
        {
            String token = ReadText.nextLine().replaceAll("([^a-zA-Z .!?]|^\")", "").toLowerCase();

            whole = whole + token;
        }

        if(whole.length() % 2 == 1)
        {
            whole = whole + whole.substring(whole.length()-1,whole.length());
        }

        ReadText.close();

    }

    //Encrypt Text by first splitting "whole" into pairs.  From there changing the letters to numbers.  Then from a string to a double.  Then multiply the matrix. Mod by 26.  Change back to letters
    static void EncryptText() throws FileNotFoundException
    {

        int I = 0,I2 = 2;

        while(I2<whole.length()+2)
        {
            String pair = whole.substring(I, I2);
            I = I + 2;
            I2 = I2 + 2;

            String Fpair = pair.substring(0,1);
            String Spair = pair.substring(1,2);


            if(Fpair.equals("a")){Fpair = "1";}if(Fpair.equals("b")){Fpair = "2";}if(Fpair.equals("c")){Fpair = "3";}if(Fpair.equals("d")){Fpair = "4";}if(Fpair.equals("e")){Fpair = "5";}if(Fpair.equals("f")){Fpair = "6";}if(Fpair.equals("g")){Fpair = "7";}if(Fpair.equals("h")){Fpair = "8";}if(Fpair.equals("i")){Fpair = "9";}if(Fpair.equals("j")){Fpair = "10";}if(Fpair.equals("k")){Fpair = "11";}if(Fpair.equals("l")){Fpair = "12";}if(Fpair.equals("m")){Fpair = "13";}if(Fpair.equals("n")){Fpair = "14";}if(Fpair.equals("o")){Fpair = "15";}if(Fpair.equals("p")){Fpair = "16";}if(Fpair.equals("q")){Fpair = "17";}if(Fpair.equals("r")){Fpair = "18";}if(Fpair.equals("s")){Fpair = "19";}if(Fpair.equals("t")){Fpair = "20";}if(Fpair.equals("u")){Fpair = "21";}if(Fpair.equals("v")){Fpair = "22";}if(Fpair.equals("w")){Fpair = "23";}if(Fpair.equals("x")){Fpair = "24";}if(Fpair.equals("y")){Fpair = "25";}if(Fpair.equals("z")){Fpair = "26";}if(Fpair.equals(" ")){Fpair = "27";}if(Fpair.equals(".")){Fpair = "28";}if(Fpair.equals("?")){Fpair = "0";}if(Fpair.equals("!")){Fpair = "28";}
            if(Spair.equals("a")){Spair = "1";}if(Spair.equals("b")){Spair = "2";}if(Spair.equals("c")){Spair = "3";}if(Spair.equals("d")){Spair = "4";}if(Spair.equals("e")){Spair = "5";}if(Spair.equals("f")){Spair = "6";}if(Spair.equals("g")){Spair = "7";}if(Spair.equals("h")){Spair = "8";}if(Spair.equals("i")){Spair = "9";}if(Spair.equals("j")){Spair = "10";}if(Spair.equals("k")){Spair = "11";}if(Spair.equals("l")){Spair = "12";}if(Spair.equals("m")){Spair = "13";}if(Spair.equals("n")){Spair = "14";}if(Spair.equals("o")){Spair = "15";}if(Spair.equals("p")){Spair = "16";}if(Spair.equals("q")){Spair = "17";}if(Spair.equals("r")){Spair = "18";}if(Spair.equals("s")){Spair = "19";}if(Spair.equals("t")){Spair = "20";}if(Spair.equals("u")){Spair = "21";}if(Spair.equals("v")){Spair = "22";}if(Spair.equals("w")){Spair = "23";}if(Spair.equals("x")){Spair = "24";}if(Spair.equals("y")){Spair = "25";}if(Spair.equals("z")){Spair = "26";}if(Spair.equals(" ")){Spair = "27";}if(Spair.equals(".")){Spair = "28";}if(Spair.equals("?")){Spair = "0";}if(Spair.equals("!")){Spair = "28";}


            FpairNum = Double.parseDouble(Fpair);
            SpairNum = Double.parseDouble(Spair);

            TopAnswer = (TopLeftNum * FpairNum)+(TopRightNum * SpairNum);
            BottomAnswer = (BottomLeftNum * FpairNum)+(BottomRightNum * SpairNum);

            if(TopAnswer > NumOfLetters-1)
            {
                TopAnswer = TopAnswer % NumOfLetters;
            }
            if(BottomAnswer > NumOfLetters-1)
            {
                BottomAnswer = BottomAnswer % NumOfLetters;
            }

            DecimalFormat df = new DecimalFormat("0.#");

            Fpair = df.format(TopAnswer);
            Spair = df.format(BottomAnswer);

            if(Fpair.equals("1")){Fpair = "a";}if(Fpair.equals("2")){Fpair = "b";}if(Fpair.equals("3")){Fpair = "c";}if(Fpair.equals("4")){Fpair = "d";}if(Fpair.equals("5")){Fpair = "e";}if(Fpair.equals("6")){Fpair = "f";}if(Fpair.equals("7")){Fpair = "g";}if(Fpair.equals("8")){Fpair = "h";}if(Fpair.equals("9")){Fpair = "i";}if(Fpair.equals("10")){Fpair = "j";}if(Fpair.equals("11")){Fpair = "k";}if(Fpair.equals("12")){Fpair = "l";}if(Fpair.equals("13")){Fpair = "m";}if(Fpair.equals("14")){Fpair = "n";}if(Fpair.equals("15")){Fpair = "o";}if(Fpair.equals("16")){Fpair = "p";}if(Fpair.equals("17")){Fpair = "q";}if(Fpair.equals("18")){Fpair = "r";}if(Fpair.equals("19")){Fpair = "s";}if(Fpair.equals("20")){Fpair = "t";}if(Fpair.equals("21")){Fpair = "u";}if(Fpair.equals("22")){Fpair = "v";}if(Fpair.equals("23")){Fpair = "w";}if(Fpair.equals("24")){Fpair = "x";}if(Fpair.equals("25")){Fpair = "y";}if(Fpair.equals("26")){Fpair = "z";}if(Fpair.equals("27")){Fpair = " ";}if(Fpair.equals("28")){Fpair = ".";}if(Fpair.equals("0")){Fpair = "?";}
            if(Spair.equals("1")){Spair = "a";}if(Spair.equals("2")){Spair = "b";}if(Spair.equals("3")){Spair = "c";}if(Spair.equals("4")){Spair = "d";}if(Spair.equals("5")){Spair = "e";}if(Spair.equals("6")){Spair = "f";}if(Spair.equals("7")){Spair = "g";}if(Spair.equals("8")){Spair = "h";}if(Spair.equals("9")){Spair = "i";}if(Spair.equals("10")){Spair = "j";}if(Spair.equals("11")){Spair = "k";}if(Spair.equals("12")){Spair = "l";}if(Spair.equals("13")){Spair = "m";}if(Spair.equals("14")){Spair = "n";}if(Spair.equals("15")){Spair = "o";}if(Spair.equals("16")){Spair = "p";}if(Spair.equals("17")){Spair = "q";}if(Spair.equals("18")){Spair = "r";}if(Spair.equals("19")){Spair = "s";}if(Spair.equals("20")){Spair = "t";}if(Spair.equals("21")){Spair = "u";}if(Spair.equals("22")){Spair = "v";}if(Spair.equals("23")){Spair = "w";}if(Spair.equals("24")){Spair = "x";}if(Spair.equals("25")){Spair = "y";}if(Spair.equals("26")){Spair = "z";}if(Spair.equals("27")){Spair = " ";}if(Spair.equals("28")){Spair = ".";}if(Spair.equals("0")){Spair = "?";}

            OutputText = OutputText +Fpair + Spair;
        }
    }

    //Decrypt Text by first finding its inverse.  Then find the Det and Mod it by 26.  Change the Det to a different number.  Det * the key matrix.  If less then 0 + 26 until above 26.  Mod 26.  From there changing the letters to numbers.  Then from a string to a double.  Then multiply the matrix. Mod by 26.  Change back to letters
    static void DecryptText() throws FileNotFoundException
    {
        DecimalFormat df = new DecimalFormat("0.#");

        TopRightNum = TopRightNum * -1;
        BottomLeftNum = BottomLeftNum * -1;

        double ExtraNum = TopLeftNum;
        TopLeftNum = BottomRightNum;
        BottomRightNum = ExtraNum;

        double Det = (TopLeftNum * BottomRightNum)-(TopRightNum * BottomLeftNum);
        while(Det < 0)
        {
            Det = Det + NumOfLetters;
        }
        Det = Det % NumOfLetters;

        String DetString = Double.toString(Det);

        DetString = df.format(Det);

        if(DetString.equals("2")){Det = 15;}if(DetString.equals("3")){Det = 10;}if(DetString.equals("4")){Det = 22;}if(DetString.equals("5")){Det = 6;}if(DetString.equals("6")){Det = 5;}if(DetString.equals("7")){Det = 25;}if(DetString.equals("8")){Det = 11;}if(DetString.equals("9")){Det = 13;}if(DetString.equals("10")){Det = 3;}if(DetString.equals("11")){Det = 8;}if(DetString.equals("12")){Det = 17;}if(DetString.equals("13")){Det = 9;}if(DetString.equals("14")){Det = 27;}if(DetString.equals("15")){Det = 2;}if(DetString.equals("16")){Det = 20;}if(DetString.equals("17")){Det = 12;}if(DetString.equals("18")){Det = 21;}if(DetString.equals("19")){Det = 26;}if(DetString.equals("20")){Det = 16;}if(DetString.equals("21")){Det = 18;}if(DetString.equals("22")){Det = 4;}if(DetString.equals("23")){Det = 24;}if(DetString.equals("24")){Det = 23;}if(DetString.equals("25")){Det = 7;}if(DetString.equals("26")){Det = 19;}if(DetString.equals("27")){Det = 14;}

        TopLeftNum = (Det*TopLeftNum);
        TopRightNum = (Det*TopRightNum);
        BottomLeftNum = (Det*BottomLeftNum);
        BottomRightNum = (Det*BottomRightNum);

        while(TopRightNum <= 1)
        {
            TopRightNum = TopRightNum + NumOfLetters;
        }
        while(BottomLeftNum <= 1)
        {
            BottomLeftNum = BottomLeftNum + NumOfLetters;
        }

        TopLeftNum = TopLeftNum % NumOfLetters;
        TopRightNum = TopRightNum % NumOfLetters;
        BottomLeftNum = BottomLeftNum % NumOfLetters;
        BottomRightNum = BottomRightNum % NumOfLetters;

        int I = 0,I2 = 2;
        while(I2<whole.length()+2)
        {
            String pair = whole.substring(I, I2);
            I = I + 2;
            I2 = I2 + 2;

            String Fpair = pair.substring(0,1);
            String Spair = pair.substring(1,2);


            if(Fpair.equals("a")){Fpair = "1";}if(Fpair.equals("b")){Fpair = "2";}if(Fpair.equals("c")){Fpair = "3";}if(Fpair.equals("d")){Fpair = "4";}if(Fpair.equals("e")){Fpair = "5";}if(Fpair.equals("f")){Fpair = "6";}if(Fpair.equals("g")){Fpair = "7";}if(Fpair.equals("h")){Fpair = "8";}if(Fpair.equals("i")){Fpair = "9";}if(Fpair.equals("j")){Fpair = "10";}if(Fpair.equals("k")){Fpair = "11";}if(Fpair.equals("l")){Fpair = "12";}if(Fpair.equals("m")){Fpair = "13";}if(Fpair.equals("n")){Fpair = "14";}if(Fpair.equals("o")){Fpair = "15";}if(Fpair.equals("p")){Fpair = "16";}if(Fpair.equals("q")){Fpair = "17";}if(Fpair.equals("r")){Fpair = "18";}if(Fpair.equals("s")){Fpair = "19";}if(Fpair.equals("t")){Fpair = "20";}if(Fpair.equals("u")){Fpair = "21";}if(Fpair.equals("v")){Fpair = "22";}if(Fpair.equals("w")){Fpair = "23";}if(Fpair.equals("x")){Fpair = "24";}if(Fpair.equals("y")){Fpair = "25";}if(Fpair.equals("z")){Fpair = "26";}if(Fpair.equals(" ")){Fpair = "27";}if(Fpair.equals(".")){Fpair = "28";}if(Fpair.equals("?")){Fpair = "0";}if(Fpair.equals("!")){Fpair = "28";}
            if(Spair.equals("a")){Spair = "1";}if(Spair.equals("b")){Spair = "2";}if(Spair.equals("c")){Spair = "3";}if(Spair.equals("d")){Spair = "4";}if(Spair.equals("e")){Spair = "5";}if(Spair.equals("f")){Spair = "6";}if(Spair.equals("g")){Spair = "7";}if(Spair.equals("h")){Spair = "8";}if(Spair.equals("i")){Spair = "9";}if(Spair.equals("j")){Spair = "10";}if(Spair.equals("k")){Spair = "11";}if(Spair.equals("l")){Spair = "12";}if(Spair.equals("m")){Spair = "13";}if(Spair.equals("n")){Spair = "14";}if(Spair.equals("o")){Spair = "15";}if(Spair.equals("p")){Spair = "16";}if(Spair.equals("q")){Spair = "17";}if(Spair.equals("r")){Spair = "18";}if(Spair.equals("s")){Spair = "19";}if(Spair.equals("t")){Spair = "20";}if(Spair.equals("u")){Spair = "21";}if(Spair.equals("v")){Spair = "22";}if(Spair.equals("w")){Spair = "23";}if(Spair.equals("x")){Spair = "24";}if(Spair.equals("y")){Spair = "25";}if(Spair.equals("z")){Spair = "26";}if(Spair.equals(" ")){Spair = "27";}if(Spair.equals(".")){Spair = "28";}if(Spair.equals("?")){Spair = "0";}if(Spair.equals("!")){Spair = "28";}


            FpairNum = Double.parseDouble(Fpair);
            SpairNum = Double.parseDouble(Spair);


            TopAnswer = (TopLeftNum * FpairNum)+(TopRightNum * SpairNum);
            BottomAnswer = (BottomLeftNum * FpairNum)+(BottomRightNum * SpairNum);

            if(TopAnswer > NumOfLetters-1)
            {
                TopAnswer = TopAnswer % NumOfLetters;
            }
            if(BottomAnswer > NumOfLetters-1)
            {
                BottomAnswer = BottomAnswer % NumOfLetters;
            }

            Fpair = df.format(TopAnswer);
            Spair = df.format(BottomAnswer);

            if(Fpair.equals("1")){Fpair = "a";}if(Fpair.equals("2")){Fpair = "b";}if(Fpair.equals("3")){Fpair = "c";}if(Fpair.equals("4")){Fpair = "d";}if(Fpair.equals("5")){Fpair = "e";}if(Fpair.equals("6")){Fpair = "f";}if(Fpair.equals("7")){Fpair = "g";}if(Fpair.equals("8")){Fpair = "h";}if(Fpair.equals("9")){Fpair = "i";}if(Fpair.equals("10")){Fpair = "j";}if(Fpair.equals("11")){Fpair = "k";}if(Fpair.equals("12")){Fpair = "l";}if(Fpair.equals("13")){Fpair = "m";}if(Fpair.equals("14")){Fpair = "n";}if(Fpair.equals("15")){Fpair = "o";}if(Fpair.equals("16")){Fpair = "p";}if(Fpair.equals("17")){Fpair = "q";}if(Fpair.equals("18")){Fpair = "r";}if(Fpair.equals("19")){Fpair = "s";}if(Fpair.equals("20")){Fpair = "t";}if(Fpair.equals("21")){Fpair = "u";}if(Fpair.equals("22")){Fpair = "v";}if(Fpair.equals("23")){Fpair = "w";}if(Fpair.equals("24")){Fpair = "x";}if(Fpair.equals("25")){Fpair = "y";}if(Fpair.equals("26")){Fpair = "z";}if(Fpair.equals("27")){Fpair = " ";}if(Fpair.equals("28")){Fpair = ".";}if(Fpair.equals("0")){Fpair = "?";}
            if(Spair.equals("1")){Spair = "a";}if(Spair.equals("2")){Spair = "b";}if(Spair.equals("3")){Spair = "c";}if(Spair.equals("4")){Spair = "d";}if(Spair.equals("5")){Spair = "e";}if(Spair.equals("6")){Spair = "f";}if(Spair.equals("7")){Spair = "g";}if(Spair.equals("8")){Spair = "h";}if(Spair.equals("9")){Spair = "i";}if(Spair.equals("10")){Spair = "j";}if(Spair.equals("11")){Spair = "k";}if(Spair.equals("12")){Spair = "l";}if(Spair.equals("13")){Spair = "m";}if(Spair.equals("14")){Spair = "n";}if(Spair.equals("15")){Spair = "o";}if(Spair.equals("16")){Spair = "p";}if(Spair.equals("17")){Spair = "q";}if(Spair.equals("18")){Spair = "r";}if(Spair.equals("19")){Spair = "s";}if(Spair.equals("20")){Spair = "t";}if(Spair.equals("21")){Spair = "u";}if(Spair.equals("22")){Spair = "v";}if(Spair.equals("23")){Spair = "w";}if(Spair.equals("24")){Spair = "x";}if(Spair.equals("25")){Spair = "y";}if(Spair.equals("26")){Spair = "z";}if(Spair.equals("27")){Spair = " ";}if(Spair.equals("28")){Spair = ".";}if(Spair.equals("0")){Spair = "?";}

            OutputText = OutputText +Fpair + Spair;

        }
    }

    //Print the answer to a File
    static void PrintToFile() throws FileNotFoundException
    {
        try{
            PrintWriter writer = new PrintWriter(FileToWrite, "UTF-8");
            if(FileToWrite.equals("EncryptedText.txt")){writer.print(OutputText);}//writer.print(Key);}		//If you wanted it to print the key with it
            if(FileToWrite.equals("DecryptedText.txt")){writer.print(OutputText);}
            writer.close();
        } catch (Exception e) {
            System.out.println("Could Not Find File To Print To");
        }
    }

    //Ask what you would like to do
    public static void main(String args[]) throws FileNotFoundException
    {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);

        Choice = "";

        System.out.println("Would You like to Encrypt or Decrypt Text?");
        System.out.print("Encrypt-1  ");
        System.out.print("Decrypt-2  ");

        Choice = keyboard.next();

        while(!Choice.equals("1") &&!Choice.equals("2"))
        {
            System.out.println("Error: Please Select Either 1 or 2 to Encrypt or Decrypt  ");
            System.out.print("Encrypt-1  ");
            System.out.print("Decrypt-2  ");
            Choice = keyboard.next();
        }

        if(Choice.equals("1"))
        {
            FileToGrab = "ToEncryptText.txt";
            FileToWrite = "EncryptedText.txt";
            GetKey();
            GetText();
            EncryptText();
            PrintToFile();
            System.out.println("Your Text Encrypted With Key "+Key+" Is: ");
            System.out.println(OutputText);
        }
        if(Choice.equals("2"))
        {
            FileToGrab = "EncryptedText.txt";
            FileToWrite = "DecryptedText.txt";
            GetKey();
            GetText();
            DecryptText();
            PrintToFile();
            System.out.println("Your Text Decrypted With Key "+Key+" Is: ");
            System.out.println(OutputText);
        }

    }
}