package com.jakub.energy.carbonintensity.model;

import java.util.List;

public record CarbonIntensityGenerationResponse(
        List<GenerationInterval> data
) {
}
