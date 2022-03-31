package com.company;

import java.util.Random;

public class Main {


    public static void main() {
        // write your code here
    }
        public static int[] heroesHealth = {270, 180, 260, 290, 400};
        public static int[] heroesDamage = {20, 15, 25, 40};
        public static String[] heroeAttackType = {"Physical", "Magical", "Kinetic", "Medic"};
        public static int bossHealth = 400;
        public static int bossDamage = 50;
        public static String bossDefene = "";
        public static void medicHealth () {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (i == 3) {
                    continue;
                }

                if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && heroesHealth[3] > 0) {
                    heroesHealth[i] += 100;
                    System.out.println("Medic health" + heroeAttackType[i]);
                    break;
                }
            }
        }
        public static int roundNumber = 0;
        public static void main (String[]args){
            printStatistics();
            while (!isGameFinished()) {
                round();
            }
        }
        public static void round () {
            roundNumber++;
            bossHits();
            heroHits();
        }

        public static boolean isGameFinished () {
            if (bossHealth <= 0) {
                System.out.println("HERO WIN!!!");
                return true;
            }
            if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0) {
                System.out.println("BOSS WIN!!!");
                return true;
            }
            return false;
        }
        public static void heroHits () {
            for (int i = 0; i < heroesDamage.length; i++) {
                if (heroesHealth[i] > 0 && bossHealth > 0) {
                    if (heroeAttackType[i] == bossDefene) {
                        Random random = new Random();
                        int coeff = random.nextInt(10);
                        if (bossHealth - heroesDamage[i] * coeff < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i] * coeff;
                        }
                        System.out.println("Critical damage: " + heroesDamage[i] * coeff);
                    } else {
                        if (bossHealth - heroesDamage[i] < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i];
                        }
                    }
                }
            }
        }
        public static void bossHits () {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    if (heroesHealth[i] - bossDamage < 0) {
                        heroesHealth[i] = 0;
                    } else {
                        heroesHealth[i] = heroesHealth[i] - bossDamage;
                    }
                }
            }
        }

        public static void printStatistics () {
            System.out.println(roundNumber + "ROUND--------------");
            System.out.println("Boss health" + bossHealth + "[" + bossDamage + "]");
            for (int i = 0; i < heroesHealth.length; i++) {
                System.out.println(heroeAttackType[i] + " health" + heroesHealth[i] + "[" + heroesDamage[i] + "]");
            }
            System.out.println("-----------------");
        }
    }

