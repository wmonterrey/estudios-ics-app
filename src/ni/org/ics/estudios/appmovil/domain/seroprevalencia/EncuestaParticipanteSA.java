package ni.org.ics.estudios.appmovil.domain.seroprevalencia;

import ni.org.ics.estudios.appmovil.domain.BaseMetaData;
import ni.org.ics.estudios.appmovil.domain.Participante;

/**
 * Created by Miguel Salinas on 5/25/2017.
 * V1.0
 */
public class EncuestaParticipanteSA extends BaseMetaData {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String codigo;
	private Participante participante;
    //Aspectos Educacionales
    private String escuchadoZikaSn;
    private String queEsSika;
    private String otroQueEsSika;
    private String transmiteZika;
    private String otroTransmiteZika;
    //Sintomas Previos
    private String sintomas;
    //Diagnostico previo por Arbovirus
    //Diagnostico previo por Zika
    private String tenidoZikaSn;
    private String fechaZika;
    private String sintomasZika;
    private String zikaConfirmadoMedico;
    //Diagnostico previo de Dengue
    private String tenidoDengueSn;
    private String fechaDengue;
    private String dengueConfirmadoMedico;
    //Diagnostico Previo de Chikungunya
    private String tenidoChikSn;
    private String fechaChik;
    private String chikConfirmadoMedico;
    //Vacunacion para fiebre Amarilla (not captured by MINSA vaccine booklet)
    private String vacunaFiebreAmarillaSn;
    private String fechaVacunaFiebreAmar;
    //Transfusion Sanguinea
    private String transfusionSangreSn;
    private String fechaTransfusionSangre;
    //Medidas para el control de vectores
    private String usaRepelentes;
    private String conoceLarvas;
    private String lugaresLarvas;
    private String otrosLugaresLarvas;
    //Aspectos eduacionales
    //Para mujeres y hombres de 16-49 anos
    private String tenidoHijos;
    private String usaPlanificacionFam;
    private String usaCondon;
    private String usaOtroMetodo;
    //MA 2018
    private String sabeZika;
    private String usaRopa;
    private String embarazadaUltAnio;
    private String visitaCemeneterio;
    private String cadaCuantoVisitaCem;
    private String mesesVisitaCementerio;
    private String descOtroMetodo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public String getEscuchadoZikaSn() {
        return escuchadoZikaSn;
    }

    public void setEscuchadoZikaSn(String escuchadoZikaSn) {
        this.escuchadoZikaSn = escuchadoZikaSn;
    }

    public String getQueEsSika() {
        return queEsSika;
    }

    public void setQueEsSika(String queEsSika) {
        this.queEsSika = queEsSika;
    }

    public String getOtroQueEsSika() {
        return otroQueEsSika;
    }

    public void setOtroQueEsSika(String otroQueEsSika) {
        this.otroQueEsSika = otroQueEsSika;
    }

    public String getTransmiteZika() {
        return transmiteZika;
    }

    public void setTransmiteZika(String transmiteZika) {
        this.transmiteZika = transmiteZika;
    }

    public String getOtroTransmiteZika() {
        return otroTransmiteZika;
    }

    public void setOtroTransmiteZika(String otroTransmiteZika) {
        this.otroTransmiteZika = otroTransmiteZika;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getTenidoZikaSn() {
        return tenidoZikaSn;
    }

    public void setTenidoZikaSn(String tenidoZikaSn) {
        this.tenidoZikaSn = tenidoZikaSn;
    }

    public String getFechaZika() {
        return fechaZika;
    }

    public void setFechaZika(String fechaZika) {
        this.fechaZika = fechaZika;
    }

    public String getSintomasZika() {
        return sintomasZika;
    }

    public void setSintomasZika(String sintomasZika) {
        this.sintomasZika = sintomasZika;
    }

    public String getZikaConfirmadoMedico() {
        return zikaConfirmadoMedico;
    }

    public void setZikaConfirmadoMedico(String zikaConfirmadoMedico) {
        this.zikaConfirmadoMedico = zikaConfirmadoMedico;
    }

    public String getTenidoDengueSn() {
        return tenidoDengueSn;
    }

    public void setTenidoDengueSn(String tenidoDengueSn) {
        this.tenidoDengueSn = tenidoDengueSn;
    }

    public String getFechaDengue() {
        return fechaDengue;
    }

    public void setFechaDengue(String fechaDengue) {
        this.fechaDengue = fechaDengue;
    }

    public String getDengueConfirmadoMedico() {
        return dengueConfirmadoMedico;
    }

    public void setDengueConfirmadoMedico(String dengueConfirmadoMedico) {
        this.dengueConfirmadoMedico = dengueConfirmadoMedico;
    }

    public String getTenidoChikSn() {
        return tenidoChikSn;
    }

    public void setTenidoChikSn(String tenidoChikSn) {
        this.tenidoChikSn = tenidoChikSn;
    }

    public String getFechaChik() {
        return fechaChik;
    }

    public void setFechaChik(String fechaChik) {
        this.fechaChik = fechaChik;
    }

    public String getChikConfirmadoMedico() {
        return chikConfirmadoMedico;
    }

    public void setChikConfirmadoMedico(String chikConfirmadoMedico) {
        this.chikConfirmadoMedico = chikConfirmadoMedico;
    }

    public String getVacunaFiebreAmarillaSn() {
        return vacunaFiebreAmarillaSn;
    }

    public void setVacunaFiebreAmarillaSn(String vacunaFiebreAmarillaSn) {
        this.vacunaFiebreAmarillaSn = vacunaFiebreAmarillaSn;
    }

    public String getFechaVacunaFiebreAmar() {
        return fechaVacunaFiebreAmar;
    }

    public void setFechaVacunaFiebreAmar(String fechaVacunaFiebreAmar) {
        this.fechaVacunaFiebreAmar = fechaVacunaFiebreAmar;
    }

    public String getTransfusionSangreSn() {
        return transfusionSangreSn;
    }

    public void setTransfusionSangreSn(String transfusionSangreSn) {
        this.transfusionSangreSn = transfusionSangreSn;
    }

    public String getFechaTransfusionSangre() {
        return fechaTransfusionSangre;
    }

    public void setFechaTransfusionSangre(String fechaTransfusionSangre) {
        this.fechaTransfusionSangre = fechaTransfusionSangre;
    }

    public String getUsaRepelentes() {
        return usaRepelentes;
    }

    public void setUsaRepelentes(String usaRepelentes) {
        this.usaRepelentes = usaRepelentes;
    }

    public String getConoceLarvas() {
        return conoceLarvas;
    }

    public void setConoceLarvas(String conoceLarvas) {
        this.conoceLarvas = conoceLarvas;
    }

    public String getLugaresLarvas() {
        return lugaresLarvas;
    }

    public void setLugaresLarvas(String lugaresLarvas) {
        this.lugaresLarvas = lugaresLarvas;
    }

    public String getOtrosLugaresLarvas() {
        return otrosLugaresLarvas;
    }

    public void setOtrosLugaresLarvas(String otrosLugaresLarvas) {
        this.otrosLugaresLarvas = otrosLugaresLarvas;
    }

    public String getTenidoHijos() {
        return tenidoHijos;
    }

    public void setTenidoHijos(String tenidoHijos) {
        this.tenidoHijos = tenidoHijos;
    }

    public String getUsaPlanificacionFam() {
        return usaPlanificacionFam;
    }

    public void setUsaPlanificacionFam(String usaPlanificacionFam) {
        this.usaPlanificacionFam = usaPlanificacionFam;
    }

    public String getUsaCondon() {
        return usaCondon;
    }

    public void setUsaCondon(String usaCondon) {
        this.usaCondon = usaCondon;
    }

    public String getUsaOtroMetodo() {
        return usaOtroMetodo;
    }

    public void setUsaOtroMetodo(String usaOtroMetodo) {
        this.usaOtroMetodo = usaOtroMetodo;
    }

    public String getSabeZika() {
        return sabeZika;
    }

    public void setSabeZika(String sabeZika) {
        this.sabeZika = sabeZika;
    }

    public String getUsaRopa() {
        return usaRopa;
    }

    public void setUsaRopa(String usaRopa) {
        this.usaRopa = usaRopa;
    }

    public String getEmbarazadaUltAnio() {
        return embarazadaUltAnio;
    }

    public void setEmbarazadaUltAnio(String embarazadaUltAnio) {
        this.embarazadaUltAnio = embarazadaUltAnio;
    }

    public String getVisitaCemeneterio() {
        return visitaCemeneterio;
    }

    public void setVisitaCemeneterio(String visitaCemeneterio) {
        this.visitaCemeneterio = visitaCemeneterio;
    }

    public String getCadaCuantoVisitaCem() {
        return cadaCuantoVisitaCem;
    }

    public void setCadaCuantoVisitaCem(String cadaCuantoVisitaCem) {
        this.cadaCuantoVisitaCem = cadaCuantoVisitaCem;
    }

    public String getMesesVisitaCementerio() {
        return mesesVisitaCementerio;
    }

    public void setMesesVisitaCementerio(String mesesVisitaCementerio) {
        this.mesesVisitaCementerio = mesesVisitaCementerio;
    }

    public String getDescOtroMetodo() {
        return descOtroMetodo;
    }

    public void setDescOtroMetodo(String descOtroMetodo) {
        this.descOtroMetodo = descOtroMetodo;
    }

    @Override
    public String toString() {
        return "EncuestaParticipanteSA{" + codigo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EncuestaParticipanteSA)) return false;

        EncuestaParticipanteSA that = (EncuestaParticipanteSA) o;

        if (!codigo.equals(that.codigo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
