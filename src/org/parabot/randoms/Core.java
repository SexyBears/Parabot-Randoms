package org.parabot.randoms;

import org.parabot.core.Context;
import org.parabot.environment.scripts.randoms.Random;
import org.parabot.randoms.ikov.MathSolver;
import org.parabot.randoms.pkhonor.Jail;
import org.parabot.randoms.pkhonor.MysteriousOldMan;
import org.parabot.randoms.pkhonor.SandwichLady;
import org.parabot.randoms.pkhonor.TriangleSandwich;
import org.parabot.randoms.soulsplit.BrokenPickAxe;

import java.util.ArrayList;

/**
 * @author JKetelaar
 */
public class Core {
    private ArrayList<Random> randoms = new ArrayList<Random>();

    public void init(String server) {
        randoms.add(new Jail());
        randoms.add(new TriangleSandwich());
        randoms.add(new SandwichLady());
        randoms.add(new MysteriousOldMan());
        randoms.add(new BrokenPickAxe());
        randoms.add(new MathSolver());

        org.parabot.core.Core.verbose("Possible randoms:");
        for (Random random : randoms) {
            if (random.getServer().toLowerCase().equalsIgnoreCase(server.toLowerCase())) {
                org.parabot.core.Core.verbose("-> " + random.getName());
                Context.getInstance().getRandomHandler().addRandom(random);
            }
        }
    }
}
