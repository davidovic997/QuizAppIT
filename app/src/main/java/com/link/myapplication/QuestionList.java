package com.link.myapplication;
public class QuestionList {

    public static String question[] ={
            "Šta znači skraćenica PC?",
            "Koja od navedenih komponenti je neophodna da bi računar radio?",
            "Kojem od navedenih uređaja se brzina rada meri u gigahercima (GHz)?",
            "ROM je skraćenica od?",
            "RAM je skraćenica od?"

    };

    public static String answers[][] = {
            {"Personalni računar","Računar","Mikroračunar"},
            {"CD-ROM","Disketa","Procesor"},
            {"Hard disk","Modem","CPU"},
            {"Random Only Memory","Real Archive Mode","Read Only Memory"},
            {"Random Access Memory","Robust Archive Memory","Read Only Access Memory"}
    };

    public static String correctAnswers[] = {
            "Personalni računar",
            "Procesor",
            "CPU",
            "Read Only Memory",
            "Random Access Memory"
    };
}
