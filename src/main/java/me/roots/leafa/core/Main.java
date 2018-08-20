package me.roots.leafa.core;

import me.roots.leafa.command.commands.admin.CommandDeveloper;
import me.roots.leafa.command.managers.CommandHandler;
import me.roots.leafa.command.managers.CommandListener;
import me.roots.leafa.command.commands.info.CommandBotInfo;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import me.roots.leafa.utils.BotClass;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDABuilder jdaBuilder;

    public static void main(String[] args){
        jdaBuilder = new JDABuilder(AccountType.BOT);
        jdaBuilder.setToken(BotClass.TOKEN);
        jdaBuilder.setAutoReconnect(true);
        addCommands();
        addListeners();
        try{
            JDA jda = jdaBuilder.buildBlocking();
        }catch(LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands() {
        CommandHandler.commands.put("botinfo", new CommandBotInfo());
        CommandHandler.commands.put("dev", new CommandDeveloper());
    }

    public static void addListeners() {
        jdaBuilder.addEventListener(new CommandListener());
    }

}
