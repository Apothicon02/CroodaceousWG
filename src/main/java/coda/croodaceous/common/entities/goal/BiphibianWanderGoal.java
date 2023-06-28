package coda.croodaceous.common.entities.goal;

import coda.croodaceous.common.entities.BiphibianAnimal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

public class BiphibianWanderGoal extends WaterAvoidingRandomFlyingGoal {

    protected final BiphibianAnimal entity;
    protected final double flyingChance;
    protected int verticalSearchRange;

    /**
     * @param entity the entity
     * @param speedModifier the movement speed modifier
     * @param flyingChance the percent chance to choose an airbound destination
     */
    public BiphibianWanderGoal(final BiphibianAnimal entity, final double speedModifier,
                               final double flyingChance) {
        this(entity, speedModifier, flyingChance, DEFAULT_INTERVAL);
    }

    /**
     * @param entity the entity
     * @param speedModifier the movement speed modifier
     * @param flyingChance the percent chance to choose an airbound destination
     * @param interval the interval in ticks between random destination triggers
     */
    public BiphibianWanderGoal(final BiphibianAnimal entity, final double speedModifier,
                               final double flyingChance, final int interval) {
        super(entity, speedModifier);
        this.setInterval(interval);
        this.entity = entity;
        this.flyingChance = flyingChance;
        this.verticalSearchRange = 2;
    }

    @Override
    public boolean canUse() {
        return super.canUse();
    }

    @Override
    public void start() {
        super.start();
        final boolean wantsToFly = this.entity.prefersToFly(wantedX, wantedY, wantedZ);
        this.entity.setWantsToFly(wantsToFly);
    }

    @Override
    protected Vec3 getPosition() {
        if (this.entity.getRandom().nextFloat() < flyingChance) {
            Vec3 vec3 = this.mob.getViewVector(0.0F);
            Vec3 vec31 = HoverRandomPos.getPos(this.mob, 10, this.verticalSearchRange, vec3.x, vec3.z, Mth.HALF_PI, 3, 1);
            return vec31 != null ? vec31 : AirAndWaterRandomPos.getPos(this.mob, 8, 4, -2, vec3.x, vec3.z, Mth.HALF_PI);
        }
        if (this.mob.isInWaterOrBubble()) {
            Vec3 vec3 = LandRandomPos.getPos(this.mob, 15, 7);
            return vec3 == null ? super.getPosition() : vec3;
        } else if (this.mob.getRandom().nextFloat() >= this.probability) {
            return LandRandomPos.getPos(this.mob, 10, 7);
        } else {
            return DefaultRandomPos.getPos(this.mob, 10, 7);
        }
    }

}
