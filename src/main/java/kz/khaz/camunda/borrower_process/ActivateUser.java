package kz.khaz.camunda.borrower_process;

import kz.khaz.camunda.Repo.BorrowerInformationRepository;
import kz.khaz.camunda.entity.BorrowerInformation;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class ActivateUser implements JavaDelegate {

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
        System.out.println(borrower_user_id);
        BorrowerInformation borrowerInformation = borrowerInformationRepository.findById(borrower_user_id).orElseThrow(() -> new BpmnError("RegistrationIdError"));


    }
}
