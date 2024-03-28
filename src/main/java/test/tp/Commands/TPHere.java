package test.tp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPHere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            if (sender.hasPermission("staff.use"))
            {
                if (args.length == 0)
                {
                    sender.sendMessage(ChatColor.RED + "Uso: /tphere <Giocatore>");
                } else if (args.length == 1)
                {
                    if (Bukkit.getPlayer(args[0]) == sender)
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Non puoi teletrasportare questo giocatore da te");
                    } else if ((Bukkit.getPlayer(args[0]) != null))
                    {
                        Bukkit.getPlayer(args[0]).teleport(((Player) sender).getLocation());
                        sender.sendMessage(ChatColor.GREEN + "Il giocatore " + ChatColor.YELLOW + Bukkit.getPlayer(args[0]).getName() + ChatColor.GREEN + " è stato teletrasportato da te");
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Il giocatore " + args[0] + ChatColor.RED + " è offline");
                    }
                }
            }
            else
            {
                sender.sendMessage(ChatColor.GRAY + "Comando sconosciuto");
            }
        }
        else
        {
            System.out.println("Non puoi eseguire questo comando!");
        }
        return false;
    }
}
