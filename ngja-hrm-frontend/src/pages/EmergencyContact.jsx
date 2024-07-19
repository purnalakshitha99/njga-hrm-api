import React, { useState, useEffect } from 'react';
import AxiosInstance from "../api/Axios";

function EmergencyContact() {
  const [emergencyList, setEmergencyList] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
      const fetchEmergency = async () => {
          const config = {
              headers: {
                  'version': 'v1'
              }
          };
          try {
              
              const response = await AxiosInstance.get(`employees/3/emergency-contacts`, config);
              setEmergencyList(response.data);
          } catch (error) {
              console.error('Error fetching  emergency contacts:', error);
              setError('Error fetching emergency contacts. Please try again later.');
          }
      };

      fetchEmergency();
  }, []); 

  if (error) {
      return <div>Error: {error}</div>;
  }

  if (emergencyList.length === 0) {
      return <div>Loading emergency contacts...</div>;
  }

  return (
    <div className="tab-pane fade" id="navs-top-emergencyContact" role="tabpanel">
      {emergencyList.map((emergency, index) => (
                <div key={index} className="card mb-3"> 
                    <div className="card-body">
                        <div className="row">
                            <div className="col-md-6">
                                {/* <h5 className="card-title">Emergency Contact Details</h5> */}
                                <p className="card-text"><strong>Name:</strong> {emergency.name}</p>
                                <p className="card-text"><strong>Relationship:</strong> {emergency.relationship}</p>
                                <p className="card-text"><strong>Mobile :</strong> {emergency.contact}</p>
                            </div>
                            <div className="col-md-6">
                                
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default EmergencyContact;
