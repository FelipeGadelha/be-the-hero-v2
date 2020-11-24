import React, { useState, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom'
import { FiPower, FiTrash2 } from 'react-icons/fi';
import logoImg from '../../assets/logo.svg';
import api from '../../services/api';
import './styles.css';

export default function Profile() {
  const history = useHistory();
  const [incidents, setIncidents] = useState([]);

  const ongName = localStorage.getItem('ongName');
  const ongId = localStorage.getItem('ongId');

  useEffect(() => {
    api.get('v1/incidents/profile', {
      headers: {
        auth: ongId,
      }
    }).then(response => {
      setIncidents(response.data);
    })
  }, [ongId]);

  async function handleDeleteIncident(id){
    try{
      await api.delete(`/v1/incidents/${id}`, {
        headers: {
          auth: ongId,
        }
      });

      setIncidents(incidents.filter(incident => incident.id !== id));
    }catch (err) {
      console.log(ongId);
      console.log(id);
      
      alert('Erro ao deletar caso, tente novamente')
    }
  }

  function handleLogout() {
    localStorage.clear();

    history.push('/');
  }

  return (
    <div className="profile-container">
      <header>
        <img src={logoImg} alt="Be the Hero"/>
        <span>Bem vinda, { ongName }</span>

        <Link className="button" to="incidents/new">Cadastrar novo caso</Link>
        <button onClick={handleLogout} type="button">
          <FiPower size={18} color="#e02041"/>
        </button>
      </header>
      <h1>Casos cadastrados</h1>

      <ul>
        {incidents.map(incident => (
          <li key={incident.id}>
            <strong>CASO:</strong>
            <p>{incident.title}</p>

            <strong>DESCRIÇÂO:</strong>
            <p>{incident.description}</p>

            <strong>VALOR:</strong>
            <p>{Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL'}).format(incident.value)}</p>

            <button onClick={() => handleDeleteIncident(incident.id)}type= "button">
              <FiTrash2 size={20} color="#a8a8b3" />
            </button>
        </li>
        ))}
      </ul>


    </div>
  );
}