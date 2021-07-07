package kz.khaz.camunda.borrower_process;

import kz.khaz.camunda.Repo.BorrowerInformationRepository;
import kz.khaz.camunda.entity.BorrowerInformation;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class DeactivateUser implements JavaDelegate {

    @Autowired
    BorrowerInformationRepository borrowerInformationRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UUID borrower_user_id = null;
        try {
            borrower_user_id = UUID.fromString((String) delegateExecution.getVariable("registrationId"));
        } catch (Exception err) {
            log.error(err.getLocalizedMessage());
        }

        borrowerInformationRepository.deleteById(borrower_user_id);
    }
}
