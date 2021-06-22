package kz.khaz.camunda.borrower_process;

import kz.khaz.camunda.Repo.BorrowerInformationRepository;
import kz.khaz.camunda.entity.BorrowerInformation;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CheckBorrowerInf implements JavaDelegate {

    @Autowired
    BorrowerInformationRepository borrowerInformationRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UUID borrower_user_id = null;
        try {
            borrower_user_id = UUID.fromString((String) delegateExecution.getVariable("registrationId"));

            System.out.println(borrower_user_id);
        } catch (Exception err) {

        }


        // TODO add additional
        borrowerInformationRepository.findById(borrower_user_id).ifPresentOrElse(value -> {
            delegateExecution.setVariable("documents", value.getDocuments());
            delegateExecution.setVariable("FIO", value.getGuarantor_FIO());
        }, () -> {
            throw new BpmnError("RegistrationIdError");
        });
        Optional<BorrowerInformation> borrowerInformation = borrowerInformationRepository.findById(borrower_user_id);
    }
}
