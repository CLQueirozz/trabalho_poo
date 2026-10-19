package model;

public class Multa {
    private double valor;
    private String dataVencimento;
    private String dataPagamento;
    private String motivo;
    private boolean paga;

    public Multa(double valor, String dataVencimento, String dataPagamento, String motivo, boolean paga) {
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.motivo = motivo;
        this.paga = paga;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void pagarMulta(Multa multa) {
        multa.setPaga(true);
        multa.setDataPagamento(java.time.LocalDate.now().toString());
        multa.setValor(0.0);
        multa.setMotivo(null);
        multa.setDataVencimento(null);
    }
    
}
