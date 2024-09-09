package com.varchar6.petcast.serviceothers.domain.proposalandestimate.query.service;

import com.varchar6.petcast.serviceothers.domain.proposalandestimate.query.dto.ProposalResponseDTO;

import java.util.List;

public interface ProposalService {
    List<ProposalResponseDTO> findAllProposalsByMemberId ( int memberId );

    List<ProposalResponseDTO> findAll ();

    ProposalResponseDTO findProposalById ( int id );
}
