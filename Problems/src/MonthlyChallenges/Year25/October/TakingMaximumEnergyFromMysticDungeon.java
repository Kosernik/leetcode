package MonthlyChallenges.Year25.October;

public class TakingMaximumEnergyFromMysticDungeon {

    /**
     * LeetCode №3147. Taking Maximum Energy From the Mystic Dungeon.
     *
     * @param energy - an array of energies of each magician.
     * @param k      - the teleporting distance.
     * @return - the maximum possible energy you can gain.
     */
    public int maximumEnergy(int[] energy, int k) {
        long[] prevEnergy = new long[k];

        int kIdx = 0;

        for (int i = 0; i < energy.length; i++, kIdx = (kIdx + 1) % k) {
            if (prevEnergy[kIdx] < 0) prevEnergy[kIdx] = 0;

            prevEnergy[kIdx] += energy[i];
        }

        long maxEnergy = prevEnergy[0];
        for (long prevE : prevEnergy) {
            maxEnergy = Math.max(maxEnergy, prevE);
        }

        return (int) maxEnergy;
    }
}
