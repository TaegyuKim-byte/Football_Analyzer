public enum Formation {
    // 포백 (4명 수비수)
    F_4_2_3_1("4-2-3-1", 
        new Position[]{Position.ST, Position.LW, Position.CAM, Position.RW, 
                      Position.CDM, Position.CDM, Position.LB, Position.CB, 
                      Position.CB, Position.RB, Position.GK}),
    
    F_4_3_3("4-3-3", 
        new Position[]{Position.ST, Position.LW, Position.RW, 
                      Position.CM, Position.CM, Position.CM, 
                      Position.LB, Position.CB, Position.CB, Position.RB, Position.GK}),
    
    // 쓰리백 (3명 수비수)
    F_3_5_2("3-5-2", 
        new Position[]{Position.ST, Position.ST, 
                      Position.LM, Position.CM, Position.CM, Position.RM, 
                      Position.LWB, Position.CB, Position.CB, Position.CB, Position.GK}),
    
    F_3_4_3("3-4-3", 
        new Position[]{Position.LW, Position.ST, Position.RW, 
                      Position.LM, Position.CM, Position.CM, Position.RM, 
                      Position.CB, Position.CB, Position.CB, Position.GK});
    
    // 필드
    private String name;
    private Position[] positions;
    
    // 생성자
    Formation(String name, Position[] positions) {
        this.name = name;
        this.positions = positions;
    }
    
    // 메서드
    public String getName() { 
        return name; 
    }
    
    public Position[] getPositions() { 
        return positions; 
    }
    
    // 정적 메서드 - 선택 번호로 포메이션 반환
    public static Formation getFormationByChoice(int choice) {
        switch(choice) {
            case 1: return F_4_2_3_1;
            case 2: return F_4_3_3;
            case 3: return F_3_5_2;
            case 4: return F_3_4_3;
            default: return null;
        }
    }
    
    // 모든 포메이션 출력
    public static void showFormationMenu() {
        System.out.println("----- Formation Selection -----");
        System.out.println("--- 포백 (4명 수비수) ---");
        System.out.println("(1) 4-2-3-1 (수비형 미드필더 2명)");
        System.out.println("(2) 4-3-3 (중앙 미드필더 3명)");
        System.out.println("--- 쓰리백 (3명 수비수) ---");
        System.out.println("(3) 3-5-2 (윙백 활용, 수비형 미드필더 2명)");
        System.out.println("(4) 3-4-3 (공격형)");
    }
}
