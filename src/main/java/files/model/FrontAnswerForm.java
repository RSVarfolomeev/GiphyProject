package files.model;

import java.io.Serializable;
import java.util.Objects;

public class FrontAnswerForm implements Serializable {
    private static final long serialVersionUID = -4912517095299765461L;

    private String checkingCurrency;
    private double currencyDif;
    private String giphyUrl;
    private String status;

    public FrontAnswerForm(String checkingCurrency, double currencyDif, String giphyUrl, String status) {
        this.checkingCurrency = checkingCurrency;
        this.currencyDif = currencyDif;
        this.giphyUrl = giphyUrl;
        this.status = status;
    }

    public String getCheckingCurrency() {
        return checkingCurrency;
    }

    public void setCheckingCurrency(String checkingCurrency) {
        this.checkingCurrency = checkingCurrency;
    }

    public double getCurrencyDif() {
        return currencyDif;
    }

    public void setCurrencyDif(double currencyDif) {
        this.currencyDif = currencyDif;
    }

    public String getGiphyUrl() {
        return giphyUrl;
    }

    public void setGiphyUrl(String giphyUrl) {
        this.giphyUrl = giphyUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrontAnswerForm)) return false;
        FrontAnswerForm that = (FrontAnswerForm) o;
        return Double.compare(that.currencyDif, currencyDif) == 0 && checkingCurrency.equals(that.checkingCurrency) && giphyUrl.equals(that.giphyUrl) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkingCurrency, currencyDif, giphyUrl, status);
    }

    @Override
    public String toString() {
        return "FrontAnswerForm{" +
                "checkingCurrency='" + checkingCurrency + '\'' +
                ", currencyDif=" + currencyDif +
                ", giphyUrl='" + giphyUrl + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
