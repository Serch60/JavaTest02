package practicascloud.baselineservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import practicascloud.baselineservice.model.BaselineServiceParameters;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/BaselineService")
public class BaselineServiceController {

    @ModelAttribute ("params")
    public BaselineServiceParameters bsParams() {
        return new BaselineServiceParameters();
    }

    @GetMapping
    public String getParams() {
        return "BaselineService";
    }

    @PostMapping
    public String returnResult(@ModelAttribute("params") BaselineServiceParameters bsParam, Model model) {

        double inversionInicial = bsParam.getInversionInicial();
        double inicial = inversionInicial;

        double aportacionAnual = bsParam.getAportacionAnual();

        double porcentajeIncrementoAnual = bsParam.getPorcentajeIncrementoAnual();

        int aniosInversion = bsParam.getAniosInversion();

        double rendimientoInversion = bsParam.getRendimientoInversion();

        if ((inversionInicial >= 1000) && (aportacionAnual >= 0) && (porcentajeIncrementoAnual >= 0) && (aniosInversion > 0) && (rendimientoInversion > 0)) {

            int anio;
            double saldoInicial;
            double aportacion;
            double rendimiento;
            double saldoFinal;

            double sumaAportacionAnual = 0.0;
            double montoFinal = 0;
            double gananciaInversion = 0;


            for (int i = 1; i <= aniosInversion; i++) {
                anio = i;
                saldoInicial = inversionInicial;
                aportacion = aportacionAnual;
                rendimiento = (saldoInicial + aportacion) * (rendimientoInversion / 100);
                saldoFinal = saldoInicial + aportacion + rendimiento;

                sumaAportacionAnual += aportacion;

                montoFinal = saldoFinal;
                gananciaInversion = montoFinal - inicial - sumaAportacionAnual;

                inversionInicial = saldoFinal;
                aportacionAnual = (aportacion) * (1 + (porcentajeIncrementoAnual / 100));

                model.addAttribute("gananciaInversion", Math.ceil(gananciaInversion));
                model.addAttribute("montoFinal", Math.ceil(montoFinal));

                /*List<Double> inversiones = new ArrayList<>();
                inversiones.add(new Double(+anio + Math.ceil(saldoInicial) + Math.ceil(aportacion) + Math.ceil(rendimiento) + + Math.ceil(aportacion) + Math.ceil(saldoFinal)));
                model.addAttribute("inversiones", inversiones);*/

                model.addAttribute("anio", anio);
                model.addAttribute("saldoInicial", Math.ceil(saldoInicial));
                model.addAttribute("aportacion", Math.ceil(aportacion));
                model.addAttribute("rendimiento", +Math.ceil(rendimiento));
                model.addAttribute("saldoFinal", +Math.ceil(saldoFinal));
            }
        }
        return "BaselineService";
    }
}
