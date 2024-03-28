package test.tp.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player)
        {
            if (sender.hasPermission("staff.use"))
            {
                if (args.length == 0)
                {
                    sender.sendMessage(ChatColor.RED + "Uso: /tp <Giocatore>");
                }
                else if (args.length == 1)
                {
                    if (Bukkit.getPlayer(args[0]) == sender)
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Non puoi teletrasportarti da questo giocatore");
                    }
                    else if ((Bukkit.getPlayer(args[0]) != null))
                    {
                        ((Player) sender).teleport(Bukkit.getPlayer(args[0]).getLocation());
                        sender.sendMessage(ChatColor.GREEN + "Ti sei teletrasportato con successo dal giocatore " + ChatColor.YELLOW + Bukkit.getPlayer(args[0]).getName());
                    }
                    else if (Bukkit.getPlayer(args[0]) == sender)
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Non puoi teletrasportarti da te stesso");
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Il giocatore " + args[0] + ChatColor.RED + " è offline");
                    }
                }
                else if (args.length == 2)
                {
                    if (Bukkit.getPlayer(args[0]) != null && Bukkit.getPlayer(args[1]) != null)
                    {
                        Bukkit.getPlayer(args[0]).teleport(Bukkit.getPlayer(args[1]).getLocation());
                        sender.sendMessage(ChatColor.YELLOW + "Il giocatore " + ChatColor.AQUA + Bukkit.getPlayer(args[0]).getName() + ChatColor.YELLOW + " è stato teletrasportato dal giocatore " + ChatColor.GREEN + Bukkit.getPlayer(args[1]).getName());
                    }
                    else if (Bukkit.getPlayer(args[0]) == null)
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Il giocatore " + args[0] + ChatColor.RED + " è offline");
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.YELLOW + "Il giocatore " + args[1] + ChatColor.RED + " è offline");
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
