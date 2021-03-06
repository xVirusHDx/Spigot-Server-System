package net.virushd.pets.pets;

import net.virushd.pets.main.FileManager;
import net.virushd.pets.pet.Option;
import net.virushd.pets.pet.Pet;
import org.bukkit.Material;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit.Type;

import java.util.ArrayList;
import java.util.Arrays;

public class Rabbit extends Pet {

	public Rabbit() {
		super(EntityType.RABBIT, FileManager.messages.getString("PetNames.Rabbit"));

		addOption(new Option("Baby", new ArrayList<>(Arrays.asList(false, true)), new Option.Action() {

			@Override
			public void run(Player p, Object theCase, Entity ent) {

				Ageable age = (Ageable) ent;
				age.setAgeLock(true);

				if (theCase.equals(true)) {
					age.setBaby();
				} else {
					age.setAdult();
				}
			}
		}, Material.EGG));

		ArrayList<Object> types = new ArrayList<>();
		for (Type type : Type.values()) {
			types.add("RabbitType." + type.toString());
		}
		addOption(new Option("RabbitType", types, new Option.Action() {

			@Override
			public void run(Player p, Object theCase, Entity ent) {
				((org.bukkit.entity.Rabbit) ent).setRabbitType(Type.valueOf(theCase.toString().replaceFirst("RabbitType.", "")));
			}
		}, Material.BOOK));
	}
}
