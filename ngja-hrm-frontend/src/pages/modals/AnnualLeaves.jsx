import React from 'react'
import '../../css/AnualLeaves.css'

function AnnualLeaves() {
    return (
        <>
        <div className='card ann'>
            <div className='row'>
                <div className='col'>
                    <div className="card-body">
                        <h5 className="card-title">Annual</h5>
                        <p className="card-text">
                            Leave Type
                        </p>
                    </div>
                </div>
                <div className='col'>
                    <div className="card-body">
                        <h5 className="card-title">02</h5>
                        <p className="card-text">
                            No of days
                        </p>
                    </div>
                </div>
                <div className='col'>
                    <div className="card-body">
                        <h5 className="card-title">2024.02.20</h5>
                        <p className="card-text">
                            From
                        </p>
                    </div>
                </div>
                <div className='col'>
                    <div className="card-body">
                        <h5 className="card-title">2024.02.22</h5>
                        <p className="card-text">
                            To
                        </p>
                    </div>
                </div>

            </div>
        </div>

<div>
<div className="row">
  <div className="col-xl">
    <div className="card mb-2 mt-3">
      <div className="card-header d-flex justify-content-between align-items-center">
      </div>
      <div className="card-body">
        <form>
          <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-fullname">
              Message
            </label>
            <div className='border1'></div>
            </div>
            <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-fullname">
              Documents 
            </label>
            <p>Medical_Report89657   <span><button className="" > <i class='bx bxs-download'></i></button></span></p>
            </div>
          <div className="mb-3">
            <label className="form-label" htmlFor="basic-default-message">
              Remark
            </label>
            <textarea
              id="basic-default-message"
              className="form-control"
              placeholder="Type here the Rejected Reason"
              defaultValue={""}
            />
          </div>
        </form>
      </div>
    </div>
  </div>
  
    </div>
  </div>

</>
    )
}

export default AnnualLeaves