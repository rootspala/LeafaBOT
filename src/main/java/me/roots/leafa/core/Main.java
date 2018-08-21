package me.roots.leafa.core;

import me.roots.leafa.command.commands.admin.CommandDeveloper;
import me.roots.leafa.command.commands.info.CommandBotInfo;
import me.roots.leafa.command.pivaman.BotClass;
import me.roots.leafa.command.pivaman.CommandHandler;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static JDA jda;

    public static void main(String[] args){
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);

        jdaBuilder.setToken(BotClass.TOKEN);
        jdaBuilder.setAutoReconnect(true);

        addCommands(jdaBuilder);
        addListeners(jdaBuilder);

        try{
            jda = jdaBuilder.build();
        }catch(LoginException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands(JDABuilder jdaBuilder) {
        CommandHandler.registeredCmd = new ArrayList<>();

        CommandHandler.add(new CommandDeveloper());
        CommandHandler.add(new CommandBotInfo());

        //TODO comentei a linha já que você provavelmente não vai mais usar o Handler antigo
        //CommandHandler.commands.put("botinfo", new CommandBotInfo());
    }

    public static void addListeners(JDABuilder jdaBuilder) {
        //jdaBuilder.addEventListener(new CommandListener());
        jdaBuilder.addEventListener(new CommandHandler());
    }
}
