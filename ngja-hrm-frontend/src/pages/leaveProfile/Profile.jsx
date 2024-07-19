import React from 'react'
import Image1 from '../../avatars/1.png'

function Profile() {
  return (
    <div className="col card m-2">
              <h4 className="text-center mt-3">Personal Details</h4>
              <div className="row">
                <div className="col mb-3">
                  <div className="mt-2 mr-5 ">
                    <img
                      src={Image1}
                      alt="profile"
                      className="rounded w-100 h-100"
                    />
                  </div>
                </div>
                <div className="col-4 p-0 text-left">
                  <p className="fw-bold mt-3">Name :</p>
                  <h6 className="fw-bold">Department:</h6>
                  <h6 className="fw-bold">Employee Category :</h6>
                  <h6 className="fw-bold">Branch :</h6>
                </div>
                <div className="col-4 text-left">
                  <h6 className="mt-3">Purna Lakshitha</h6>
                  <h6>Mining License</h6>
                  <h6>Standard</h6>
                  <h6>Rathnapura</h6>
                </div>
              </div>
            </div>
  )
}

export default Profile
