class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 붕대 감기 t초 붕대감기 x만큼 체력회복 t초 연속으로 붕대를 감으면 y 만큼 체력 추가회복
        // 몬스터에게 공격당하면 스킬 취소 체력회복 X
        // 취소 되면 그 즉시 붕대 감기 다시 시전 연속 성공 시간 0
        // 몬스터에게 피해를 당하면 체력이 줄어드는데 0이하가 되면 죽음 체력회복 안됨
        // 목표 : 캐릭터 최대 체력과 몬스터 공격패턴이 주어질때 끝까지 생존 가능할지 죽으면 -1
        // bandage 시전 시간 1초당 회복량 추가회복량
        // attacks 공격 시간,피해량
        int nowHealth = health;
        int castTime = bandage[0];
        int secRecovery = bandage[1];
        int bonusHealing = bandage[2];
        int startTime = 0;

        // 어택 만큼
        for(int[] x : attacks){
            int attackTime = x[0];
            int damage = x[1];

            int timeDiff = attackTime-startTime-1;
            startTime = attackTime;

            // 최대 체력보다 작으면 회복
            if(nowHealth < health){
                nowHealth += secRecovery * timeDiff;
                if(timeDiff/castTime > 0) nowHealth += bonusHealing*(timeDiff/castTime);
            }
            nowHealth = Math.min(nowHealth, health);
            // 데미지 입음
            nowHealth -= damage;
            if(nowHealth <= 0) return -1;
        }

        return nowHealth;
    }
}