package br.com.rabbithole.resources.commands.admin;

import br.com.rabbithole.permissions.Permissions;
import br.com.rabbithole.resources.Resources;
import br.com.rabbithole.resources.entities.ChunkInformationEntity;
import br.com.rabbithole.resources.methods.ScamResourcesMethods;
import br.com.rabbithole.resources.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ScamCommand implements CommandExecutor {
    final Resources plugin;

    public ScamCommand(Resources plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(this.plugin.getCommand("scam")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage(StringUtils.format("<red>Apenas jogadores podem executar este Comando!"));
            return true;
        }

        /*
        if(!player.hasPermission("Resources.Admin")) {
            player.sendMessage(StringUtils.format("<red>Apenas <bold>ADMINISTRADORES</bold> podem executar este Comando!"));
            return true;
        }
         */
        if (!Permissions.getAPI().hasPermission(player.getName(), "coordinator")) { //TODO: VERIFICAR PERMISSION API
            player.sendMessage(StringUtils.format("<red>Apenas <bold>ADMINISTRADORES</bold> podem executar este Comando!"));
            return true;
        }

        ChunkInformationEntity chunkInformation = ScamResourcesMethods.sendResourcesInformation(player);

        showResults(player, chunkInformation);
        return false;
    }

    private void showResults(Player player, ChunkInformationEntity chunkInformation) {
        player.sendMessage(StringUtils.format("<green><bold>Relatório de Recursos da Chunk"));
        player.sendMessage(StringUtils.format(""));
        chunkInformation.getMaterials().forEach((key, value) -> player.sendMessage(StringUtils.format("<grey>%s</grey>: <gold>%s".formatted(key, createGraphic(value)))));
    }

    private String createGraphic(int numberOfBlocks) {
        int result = numberOfBlocks/10;
        if (result > 10) result = 10;
        if (result == 0) result = 1;
        return "■".repeat(Math.max(0, result));
    }
}
