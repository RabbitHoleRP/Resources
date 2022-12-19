package br.com.rabbithole.resources.entities;

import org.bukkit.Material;

import java.util.HashMap;

public class ChunkInformationEntity {
    private String chunkID;
    private HashMap<Material, Integer> materials;

    public ChunkInformationEntity(String chunkID, HashMap<Material, Integer> materials) {
        this.chunkID = chunkID;
        this.materials = materials;
    }

    public String getChunkID() {
        return chunkID;
    }

    public void setChunkID(String chunkID) {
        this.chunkID = chunkID;
    }

    public HashMap<Material, Integer> getMaterials() {
        return materials;
    }

    public void setMaterials(HashMap<Material, Integer> materials) {
        this.materials = materials;
    }
}
