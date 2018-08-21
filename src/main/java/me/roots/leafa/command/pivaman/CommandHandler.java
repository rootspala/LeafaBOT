package me.roots.leafa.command.pivaman;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import java.util.stream.Collectors;

public class CommandHandler extends ListenerAdapter {

    public static List<LeafaCommand> registeredCmd;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentDisplay().startsWith(BotClass.PREFIX)) {
            List<String> commandBody = new ArrayList<>(Arrays.asList(event.getMessage().getContentDisplay().replace(BotClass.PREFIX,
                    "").split(" ")));

            List<LeafaCommand> correspondingCmds = registeredCmd.stream()
                    .filter(cmd -> cmd.getName().equalsIgnoreCase(commandBody.get(0)))
                    .collect(Collectors.toList());

            if (correspondingCmds.isEmpty()) {
                /*TODO personalizável
                System.out.println("O usuário " + event.getAuthor().getName() + " disse um comando que não existe");*/
                return;
            }

            LeafaCommand command = registeredCmd.get(0);

            //TODO aqui você faz a verificação de permissão, abaixo está um exemplo de como fazer
            /*if (command.getPermission() != null && !LeafaUser.permission.string.equals(command.getPermission())) {
                System.out.println("O usuário " + event.getAuthor().getName() + " não tem permissão para o comando");
                return;
            }*/

            commandBody.remove(0);
            command.run(event, commandBody.toArray(new String[commandBody.size()]));
        }
    }

   public static void add(LeafaCommand cmd) {
       registeredCmd.add(cmd);
   }

}
