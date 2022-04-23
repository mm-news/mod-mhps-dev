package edu.mod.mod_mhps;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.mod.mod_mhps.block.*;
import edu.mod.mod_mhps.core.init.EntityInit;
import edu.mod.mod_mhps.core.init.SoundInit;
import edu.mod.mod_mhps.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mod_mhps")
public class Main
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public Main() {

        // Register item "radioactive material"
        IEventBus eventBus = 
        FMLJavaModLoadingContext.get().getModEventBus();

        RadioactiveMaterial.register(eventBus);

        RadioactiveBlock.register(eventBus);

        WallClimbingGlove.register(eventBus);

        StandWithUkraineBlock.register(eventBus);

        AntiGravityParticles.register(eventBus);

        AntiGravityStone.register(eventBus);

        EntityInit.ENTITIES.register(eventBus);

        SoundInit.SOUNDS.register(eventBus);

        DieBallSpawnEgg.register(eventBus);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        MinecraftForge.EVENT_BUS.register(new WallClimb());
        MinecraftForge.EVENT_BUS.register(new SuperJump());
        MinecraftForge.EVENT_BUS.register(new SlowFalling());
        MinecraftForge.EVENT_BUS.register(new ExplodeWhenDieDie());
        MinecraftForge.EVENT_BUS.register(new SuperTNT());
        MinecraftForge.EVENT_BUS.register(new PigDroppingDiamond());
        MinecraftForge.EVENT_BUS.register(new NoGravity());
        MinecraftForge.EVENT_BUS.register(new DieBallSpawnEgg());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    }
