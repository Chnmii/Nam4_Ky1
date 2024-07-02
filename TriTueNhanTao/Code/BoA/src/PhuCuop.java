import java.util.Objects;
public class PhuCuop {
    private int phu;
    private int cuop;
    private boolean bo;

    public PhuCuop() {

    }
    public PhuCuop(int phu, int cuop, boolean bo){
        this.cuop = cuop;
        this.phu = phu;
        this.bo = bo;
    }

    public int getPhu() {
        return phu;
    }

    public void setPhu(int phu) {
        this.phu = phu;
    }

    public int getCuop() {
        return cuop;
    }

    public void setCuop(int cuop) {
        this.cuop = cuop;
    }

    public boolean isBo() {
        return bo;
    }

    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "(" + phu +
                ", " + cuop +
                ", " + (bo ? "Bờ A" : "Bờ B") + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhuCuop phuCuop = (PhuCuop) o;
        return phu == phuCuop.phu && cuop == phuCuop.cuop && bo == phuCuop.bo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phu, cuop, bo);
    }
}
