package me.roots.leafa.core;

import me.roots.leafa.command.commands.admin.CommandDeveloper;
import me.roots.leafa.command.commands.admin.CommandTest;
import me.roots.leafa.command.commands.info.CommandBotInfo;
import me.roots.leafa.command.managers.CommandHandler;
import me.roots.leafa.utils.BotSQL;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import me.roots.leafa.utils.BotClass;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class Main {

    public static JDA jda;

    public static void main(String[] args){
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);
        jdaBuilder.setToken(BotClass.TOKEN);
        jdaBuilder.setAutoReconnect(true);
        addCommands(jdaBuilder);
        addListeners(jdaBuilder);
        try{
            JDA jda = jdaBuilder.buildBlocking();
        }catch(LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BotSQL.openConnection();
    }

    public static void addCommands(JDABuilder jdaBuilder) {
        CommandHandler.registeredCmd = new ArrayList<>();

        // CommandHandler.add(new CommandDeveloper());
        // CommandHandler.add(new CommandBotInfo());
        CommandHandler.add(new CommandTest());
    }

    public static void addListeners(JDABuilder jdaBuilder) {
        jdaBuilder.addEventListener(new CommandHandler());
    }

}
