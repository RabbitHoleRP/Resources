package br.com.rabbithole.resources.methods;

import br.com.rabbithole.resources.entities.ChunkInformationEntity;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ScamResourcesMethods {
    public static ChunkInformationEntity sendResourcesInformation(Player player) {
        return scamResources(player.getLocation().getChunk());
    }

    private static ChunkInformationEntity scamResources(Chunk chunk) {
        ChunkInformationEntity chunkInformation = new ChunkInformationEntity(chunk.getX() + "." + chunk.getZ(), new HashMap<>());
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 256; y++) {
                for (int z = 0; z < 16; z++) {
                    Block block = chunk.getBlock(x, y, z);
                    if (block.getType().equals(Material.AIR)) continue;
                    switch (block.getType()) {
                        case COAL_ORE, EMERALD_ORE, IRON_ORE, LAPIS_ORE, GOLD_ORE, REDSTONE_ORE, DIAMOND_ORE -> {
                            if (!chunkInformation.getMaterials().containsKey(block.getType())) {
                                chunkInformation.getMaterials().put(block.getType(), 1);
                            } else {
                                chunkInformation.getMaterials().put(block.getType(), chunkInformation.getMaterials().get(block.getType()) + 1);
                            }
                        }
                    }
                }
            }
        }
        return chunkInformation;
    }
}
