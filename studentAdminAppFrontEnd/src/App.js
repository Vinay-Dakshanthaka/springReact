import logo from './logo.svg';
import './App.css';
import AllStudents from './Components/AllStudents';
import UpdateStudent from './Components/UpdateStudent'
import AddStudent from './Components/AddStudents'
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<AllStudents />}></Route>
        <Route path='/addStudent' element={<AddStudent />}></Route>
        <Route path="/update/:studentId" element={<UpdateStudent />}>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
