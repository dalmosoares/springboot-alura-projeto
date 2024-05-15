package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long idConsulta,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data
) {
    public DadosDetalhamentoConsulta(Long idConsulta,Long idMedico,Long idPaciente,LocalDateTime data){
       this.idConsulta = idConsulta;
       this.idMedico = idMedico;
       this.idPaciente = idPaciente;
       this.data = data;
    }
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
