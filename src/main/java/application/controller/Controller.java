package application.controller;

import application.core.LexerTest;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    final String filePath = "/home/ubuntu/Users/alaincruzcasanova/FusionTech/content/test.text";

    @Autowired
    LexerTest lexer;

    @Autowired
    org.springframework.core.env.Environment environment;

    @RequestMapping(value = "/")
    public String getIndex() {
        return "jflex";
    }

    @ResponseBody
    @RequestMapping(value = "/jflex")
    public String[] getJFlex(@RequestParam("input") String input) {
        BufferedWriter writer = null;
        try {
            File file = new File(filePath);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(input);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String pre = lexer.readLexer(filePath);
        String[] result = pre.split("\n");
        return result;
    }

}
