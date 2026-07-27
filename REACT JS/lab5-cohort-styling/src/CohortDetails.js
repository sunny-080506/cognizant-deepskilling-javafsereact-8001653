import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const statusColor = cohort.status === 'ongoing' ? 'green' : 'blue';
  return (
    <div className={styles.box}>
      <h3 style={{ color: statusColor }}>{cohort.code}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start</dt>
        <dd>{cohort.startDate}</dd>
        <dt>End</dt>
        <dd>{cohort.endDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
