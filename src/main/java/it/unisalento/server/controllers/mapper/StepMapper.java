package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.StepDTO;
import it.unisalento.server.entities.Attachment;
import it.unisalento.server.entities.Step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StepMapper {

    public static StepDTO makeStepDTO(Step step) {

        StepDTO.StepDTOBuilder stepDTOBuilder = new StepDTO.StepDTOBuilder()
                .setId(step.getId())
                .setName(step.getName())
                .setDescription(step.getDescription())
                .setDuration(step.getDuration())
                .setEstimateDuration(step.getEstimateDuration());
        if (step.getAttachmentList() != null) {
            stepDTOBuilder.setAttachmentList(AttachmentMapper.makeAttachmentDTOList(step.getAttachmentList()));
        }
        return stepDTOBuilder.build();
    }

    public static Step makeStep(StepDTO stepDTO) {
        return new Step(
                stepDTO.getId(),
                stepDTO.getName(),
                stepDTO.getDescription(),
                stepDTO.getDuration(),
                stepDTO.getEstimateDuration(),
                AttachmentMapper.makeAttachmentList(stepDTO.getAttachmentList())
        );
    }

    public static List<StepDTO> makeStepDTOList(List<Step> stepList) {
        Iterator<Step> iter = stepList.iterator();
        List<StepDTO> stepDTOList = new ArrayList<>();
        while (iter.hasNext()) stepDTOList.add(makeStepDTO(iter.next()));
        return stepDTOList;
    }

    public static List<Step> makeStepList(List<StepDTO> stepDTOList) {
        Iterator<StepDTO> iter = stepDTOList.iterator();
        List<Step> stepList = new ArrayList<>();
        while (iter.hasNext()) stepList.add(makeStep(iter.next()));
        return stepList;
    }
}
