/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.exclusions

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.exclusions.ExclusionsRequests._

class ExclusionsSimulation extends PerformanceTestRunner {

  setup("noEligibleSales", "No eligible sales - IOSS NETP Exclusions Journey") withRequests (
    getAuthorityWizard,
    postAuthorityWizard,
    getExclusionsJourney,
    getExclusionsStoppedSellingGoods,
    postExclusionsStoppedSellingGoods(true),
    getExclusionsStoppedSellingGoodsDate,
    postExclusionsStoppedSellingGoodsDate,
    getCheckYourAnswers,
    postCheckYourAnswers,
    getClientExclusionsRequestReceived
  )

  setup("voluntary", "Voluntary - IOSS NETP Exclusions Journey") withRequests (
    getAuthorityWizard,
    postAuthorityWizard,
    getExclusionsJourney,
    getExclusionsStoppedSellingGoods,
    postExclusionsStoppedSellingGoods(false),
    getExclusionsLeaveScheme,
    postExclusionsLeaveScheme,
    getExclusionsStoppedUsingServiceDate,
    postExclusionsStoppedUsingServiceDate,
    getCheckYourAnswers,
    postCheckYourAnswers,
    getClientExclusionsRequestReceived
  )

  runSimulation()
}
