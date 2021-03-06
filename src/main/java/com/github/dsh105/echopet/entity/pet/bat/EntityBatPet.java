package com.github.dsh105.echopet.entity.pet.bat;

import net.minecraft.server.v1_6_R3.*;

import com.github.dsh105.echopet.entity.pet.EntityPet;
import com.github.dsh105.echopet.entity.pet.Pet;
import com.github.dsh105.echopet.entity.pet.SizeCategory;

public class EntityBatPet extends EntityPet {

	public EntityBatPet(World world) {
		super(world);
	}

	public EntityBatPet(World world, Pet pet) {
		super(world, pet);
		this.a(0.5F, 0.9F);
		this.fireProof = true;
	}
	
	public void setHanging(boolean flag) {
		byte b0 = this.datawatcher.getByte(16);
		if (flag) {
			this.datawatcher.watch(16, Byte.valueOf((byte) (b0 | 1)));
		}
		else {
			this.datawatcher.watch(16, Byte.valueOf((byte) (b0 & -2)));
		}
		((BatPet) pet).hanging = flag;
	}

	@Override
	protected void initDatawatcher() {
        super.initDatawatcher();
        this.datawatcher.a(16, new Byte((byte) 0));
    }
	
	@Override
	protected String getIdleSound() {
        return this.bJ()
        		&& this.random.nextInt(4) != 0 ? null : "mob.bat.idle";
    }

	@Override
	public void onLive() {
		super.onLive();
		if (this.bJ()) {
			this.motX = this.motY = this.motZ = 0.0D;
			this.locY = (double) MathHelper.floor(this.locY) + 1.0D - (double) this.length;
		} else {
			this.motY *= 0.6000000238418579D;
		}
	}
	
	@Override
	protected String getDeathSound() {
		return "mob.bat.death";
	}
	
	@Override
	public SizeCategory getSizeCategory() {
		return SizeCategory.TINY;
	}
}