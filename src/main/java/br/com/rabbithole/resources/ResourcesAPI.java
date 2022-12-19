package br.com.rabbithole.resources;

import br.com.rabbithole.resources.entities.ChunkInformationEntity;
import br.com.rabbithole.resources.methods.ScamResourcesMethods;
import org.bukkit.entity.Player;

public class ResourcesAPI {
    public ChunkInformationEntity scamResources (Player player) {
        return ScamResourcesMethods.sendResourcesInformation(player);
    }
}
