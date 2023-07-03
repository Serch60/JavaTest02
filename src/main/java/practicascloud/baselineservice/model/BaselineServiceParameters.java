package practicascloud.baselineservice.model;

public class BaselineServiceParameters {

    double inversionInicial;
    double aportacionAnual;
    double porcentajeIncrementoAnual;
    int aniosInversion;
    double rendimientoInversion;

    public double getInversionInicial() {
        return inversionInicial;
    }

    public void setInversionInicial(double inversionInicial) {
        this.inversionInicial = inversionInicial;
    }

    public double getAportacionAnual() {
        return aportacionAnual;
    }

    public void setAportacionAnual(double aportacionAnual) {
        this.aportacionAnual = aportacionAnual;
    }

    public double getPorcentajeIncrementoAnual() {
        return porcentajeIncrementoAnual;
    }

    public void setPorcentajeIncrementoAnual(double porcentajeIncrementoAnual) {
        this.porcentajeIncrementoAnual = porcentajeIncrementoAnual;
    }

    public int getAniosInversion() {
        return aniosInversion;
    }

    public void setAniosInversion(int aniosInversion) {
        this.aniosInversion = aniosInversion;
    }

    public double getRendimientoInversion() {
        return rendimientoInversion;
    }

    public void setRendimientoInversion(double rendimientoInversion) {
        this.rendimientoInversion = rendimientoInversion;
    }
}
