package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataInicio = dataConsulta.withHour(7);
        var dataFim = dataConsulta.withHour(18);
        if(consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(),dataInicio,dataFim)) {
            throw new ValidacaoException("Consulta deve ser agendada por paciente sem outra consulta no dia");
        }
    }

}
