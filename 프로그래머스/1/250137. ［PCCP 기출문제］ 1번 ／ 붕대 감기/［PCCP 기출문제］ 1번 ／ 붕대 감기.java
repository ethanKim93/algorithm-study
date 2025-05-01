class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int turn = 0;
        int attackIndex = 0;
        int chainHeal = 0;
        final int maxHealth = health;
        
        while(true){
            System.out.println( turn + " " + health);
            
            if(attackIndex == attacks.length){
                return health;
            }
            
            int[] attack = attacks[attackIndex];
            int attackTurn = attack[0];
            int damage = attack[1];
            
            if(attackTurn == ++turn){
                attackIndex++;
                chainHeal = 0;
                
                health -= damage;
                if(health <= 0){
                    return -1;
                }
                continue;
            }
            
            int skillTime = bandage[0];
            int dotHeal = bandage[1];
            int megaHeal = bandage[2];
            
            health = Math.min(maxHealth, health + dotHeal);
            chainHeal ++;
            if(chainHeal == skillTime){
                health = Math.min(maxHealth, health + megaHeal);
                chainHeal = 0;
            }
        }
    }
}