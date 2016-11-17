-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 17 Novembre 2016 à 14:13
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `statsmondiales`
--
CREATE DATABASE IF NOT EXISTS `statsmondiales` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `statsmondiales`;

-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

CREATE TABLE `annee` (
  `id` int(11) NOT NULL,
  `annee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `annee`
--

INSERT INTO `annee` (`id`, `annee`) VALUES
(1, 1985),
(2, 1986),
(3, 1987),
(4, 1988),
(5, 1989),
(6, 1990),
(7, 1991),
(8, 1992),
(9, 1993),
(10, 1994),
(11, 1995),
(12, 1996),
(13, 1997),
(14, 1998),
(15, 1999),
(16, 2000),
(17, 2001),
(18, 2002),
(19, 2003),
(20, 2004),
(21, 2005),
(22, 2006),
(23, 2007),
(24, 2008),
(25, 2009),
(26, 2010),
(27, 2011),
(28, 2012),
(29, 2013),
(30, 2014),
(31, 2015),
(32, 2016);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `id` int(11) NOT NULL,
  `nom` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`) VALUES
(1, 'Afghanistan'),
(2, 'Afrique du sud'),
(3, 'Albanie'),
(4, 'Algérie'),
(5, 'Allemagne'),
(6, 'Andorre'),
(7, 'Angola'),
(8, 'Antigua-et-Barbuda'),
(9, 'Arabie saoudite'),
(10, 'Argentine'),
(11, 'Arménie'),
(12, 'Australie'),
(13, 'Autriche'),
(14, 'Azerbaïdjan'),
(15, 'Bahamas'),
(16, 'Bahreïn'),
(17, 'Bangladesh'),
(18, 'Barbade'),
(19, 'Belgique'),
(20, 'Belize'),
(21, 'Bénin'),
(22, 'Bhoutan'),
(23, 'Biélorussie'),
(24, 'Birmanie'),
(25, 'Bolivie'),
(26, 'Bosnie-Herzégovine'),
(27, 'Botswana'),
(28, 'Brésil'),
(29, 'Brunei'),
(30, 'Bulgarie'),
(31, 'Burkina Faso'),
(32, 'Burundi'),
(33, 'Cambodge'),
(34, 'Cameroun'),
(35, 'Canada'),
(36, 'Cap-Vert'),
(37, 'Centrafrique'),
(38, 'Chili'),
(39, 'Chine'),
(40, 'Chypre'),
(41, 'Colombie'),
(42, 'Comores'),
(43, 'Congo'),
(44, 'République démocratique du Congo'),
(45, 'Cook Islands'),
(46, 'Corée du Nord'),
(47, 'Corée du Sud'),
(48, 'Costa Rica'),
(49, 'Côte d\'Ivoire'),
(50, 'Croatie'),
(51, 'Cuba'),
(52, 'Danemark'),
(53, 'Djibouti'),
(54, 'Dominique'),
(55, 'Égypte'),
(56, 'Équateur'),
(57, 'Érythrée'),
(58, 'Espagne'),
(59, 'Estonie'),
(60, 'États-Unis'),
(61, 'Éthiopie'),
(62, 'Fidji Islands'),
(63, 'Finlande'),
(64, 'France'),
(65, 'Gabon'),
(66, 'Gambie'),
(67, 'Géorgie'),
(68, 'Ghana'),
(69, 'Grèce'),
(70, 'Grenade'),
(71, 'Guatemala'),
(72, 'Guinée'),
(73, 'Guinée-Bissau'),
(74, 'Guinée équatoriale'),
(75, 'Guyana'),
(76, 'Haïti'),
(77, 'Honduras'),
(78, 'Hongrie'),
(79, 'Inde'),
(80, 'Indonésie'),
(81, 'Irak'),
(82, 'Iran'),
(83, 'Irlande'),
(84, 'Islande'),
(85, 'Israël'),
(86, 'Italie'),
(87, 'Jamaïque'),
(88, 'Japon'),
(89, 'Jordanie'),
(90, 'Kazakhstan'),
(91, 'Kenya'),
(92, 'Kirghizistan'),
(93, 'Kiribati'),
(94, 'Koweït'),
(95, 'Laos'),
(96, 'Lesotho'),
(97, 'Lettonie'),
(98, 'Liban'),
(99, 'Libéria'),
(100, 'Libye'),
(101, 'Liechtenstein'),
(102, 'Lituanie'),
(103, 'Luxembourg'),
(104, 'Macédoine'),
(105, 'Madagascar'),
(106, 'Malaisie'),
(107, 'Malawi'),
(108, 'Maldives'),
(109, 'Mali'),
(110, 'Malte'),
(111, 'Maroc'),
(112, 'Marshall Islands'),
(113, 'Maurice'),
(114, 'Mauritanie'),
(115, 'Mexique'),
(116, 'Micronésie'),
(117, 'Moldavie'),
(118, 'Monaco'),
(119, 'Mongolie'),
(120, 'Montenegro'),
(121, 'Mozambique'),
(122, 'Namibie'),
(123, 'Nauru'),
(124, 'Népal'),
(125, 'Nicaragua'),
(126, 'Niger'),
(127, 'Nigéria'),
(128, 'Niue'),
(129, 'Norvège'),
(130, 'Nouvelle-Zélande'),
(131, 'Oman'),
(132, 'Ouganda'),
(133, 'Ouzbékistan'),
(134, 'Palaos'),
(135, 'Palestine'),
(136, 'Panama'),
(137, 'Papouasie-Nouvelle-Guinée'),
(138, 'Paraguay'),
(139, 'Pays-Bas'),
(140, 'Pérou'),
(141, 'Philippines'),
(142, 'Pologne'),
(143, 'Portugal'),
(144, 'Qatar'),
(145, 'Roumanie'),
(146, 'Royaume-Uni'),
(147, 'Russie'),
(148, 'Rwanda'),
(149, 'Saint-Christophe-et-Niévès'),
(150, 'Sainte-Lucie'),
(151, 'Saint-Marin'),
(152, 'Saint-Vincent-et-les-Grenadines'),
(153, 'Salomon Islands'),
(154, 'Salvador'),
(155, 'Samoa Islands'),
(156, 'Sao Tomé-et-Principe'),
(157, 'Sénégal'),
(158, 'Serbie'),
(159, 'Seychelles'),
(160, 'Sierra Leone'),
(161, 'Singapour'),
(162, 'Slovaquie'),
(163, 'Slovénie'),
(164, 'Somalie'),
(165, 'Soudan'),
(166, 'Soudan du sud'),
(167, 'Sri Lanka'),
(168, 'Suède'),
(169, 'Suisse'),
(170, 'Suriname'),
(171, 'Swaziland'),
(172, 'Syrie'),
(173, 'Tadjikistan'),
(174, 'Tanzanie'),
(175, 'Tchad'),
(176, 'République tchèque'),
(177, 'Thaïlande'),
(178, 'Timor oriental'),
(179, 'Togo'),
(180, 'Tonga'),
(181, 'Trinité-et-Tobago'),
(182, 'Tunisie'),
(183, 'Turkménistan'),
(184, 'Turquie'),
(185, 'Tuvalu'),
(186, 'Ukraine'),
(187, 'Uruguay'),
(188, 'Vanuatu'),
(189, 'Vatican'),
(190, 'Venezuela'),
(191, 'Viêt Nam'),
(192, 'Yémen'),
(193, 'Zambie'),
(194, 'Zimbabwe');

-- --------------------------------------------------------

--
-- Structure de la table `pays_donnees`
--

CREATE TABLE `pays_donnees` (
  `id` int(11) NOT NULL,
  `id_pays` int(11) NOT NULL,
  `id_annee` int(11) NOT NULL,
  `population` double NOT NULL,
  `mortalite` double NOT NULL,
  `mortalite_infantile` double NOT NULL,
  `natalite` double NOT NULL,
  `esperance_vie` double NOT NULL,
  `croissance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `pays_donnees`
--

INSERT INTO `pays_donnees` (`id`, `id_pays`, `id_annee`, `population`, `mortalite`, `mortalite_infantile`, `natalite`, `esperance_vie`, `croissance`) VALUES
(2, 23, 1, 9481.52, 14.388, 3.564, 1.633, 71.574, -1.97),
(3, 30, 1, 7097.8, 15.458, 8.383, 1.571, 74.419, -7.36),
(4, 78, 1, 9821.32, 13.339, 4.291, 1.379, 75.433, -3.42),
(5, 117, 1, 4062.86, 11.462, 9.919, 1.241, 71.813, -1.76),
(6, 142, 1, 38593.2, 10.158, 4.116, 1.34, 77.786, -0.62),
(7, 145, 1, 19372.7, 13.427, 8.683, 1.517, 74.963, -7.07),
(8, 147, 1, 143440, 14.043, 7.523, 1.713, 70.368, -0.29),
(9, 162, 1, 5429.42, 10.075, 4.47, 1.417, 76.534, 0.54),
(10, 176, 1, 10548.1, 10.396, 2.193, 1.507, 78.923, 0.57),
(11, 186, 1, 44624.4, 15.458, 8.418, 1.539, 71.209, -4.69),
(12, 52, 1, 5690.75, 9.584, 3.515, 1.741, 80.561, 3.76),
(13, 59, 1, 1309.1, 12.342, 2.892, 1.627, 77.143, -2.6),
(14, 63, 1, 5523.9, 9.784, 1.97, 1.753, 81.196, 3.42),
(15, 83, 1, 4713.99, 6.473, 2.544, 2.004, 81.24, 6.43),
(16, 84, 1, 331.778, 6.416, 1.851, 1.91, 82.891, 7.35),
(17, 97, 1, 1955.74, 15.066, 5.78, 1.525, 74.445, -6.63),
(18, 102, 1, 2850.03, 15.969, 3.193, 1.622, 73.622, -8.38),
(19, 129, 1, 5271.96, 8.065, 2.23, 1.799, 81.868, 11.37),
(20, 146, 1, 65111.1, 9.109, 3.757, 1.913, 81.007, 6.11),
(21, 168, 1, 9851.85, 9.133, 2.579, 1.926, 82.514, 7.17),
(22, 3, 1, 2903.7, 7.57, 13.195, 1.792, 78.156, 2.54),
(23, 26, 1, 3802.13, 10.847, 6.764, 1.243, 76.787, -2.32),
(24, 50, 1, 4225, 12.666, 3.379, 1.491, 77.671, -3.61),
(25, 58, 1, 46064.6, 9.047, 2.64, 1.355, 82.95, -0.56),
(26, 69, 1, 10919.5, 11.05, 2.43, 1.306, 81.267, -2.82),
(27, 86, 1, 59801, 10.014, 1.974, 1.468, 83.518, 0),
(28, 104, 1, 2081.01, 9.588, 8.96, 1.543, 75.685, 1.17),
(29, 110, 1, 419.615, 9.095, 4.239, 1.472, 80.9, 2.21),
(30, 120, 1, 626.101, 10.129, 3.538, 1.665, 76.515, 0.37),
(31, 143, 1, 10304.4, 10.58, 2.844, 1.246, 81.417, -4.12),
(32, 158, 1, 8812.71, 12.967, 8.668, 1.584, 75.188, -4.2),
(33, 163, 1, 2069.36, 9.795, 2.809, 1.635, 80.752, 0.9),
(34, 5, 1, 80682.4, 11.138, 2.719, 1.422, 81.27, -0.32),
(35, 13, 1, 8569.63, 9.432, 2.664, 1.51, 81.777, 2.79),
(36, 19, 1, 11371.9, 9.765, 2.938, 1.826, 81.165, 6.36),
(37, 64, 1, 64668.1, 9.034, 2.952, 1.995, 82.552, 4.2),
(38, 103, 1, 576.243, 7.157, 1.341, 1.592, 82.074, 14.76),
(39, 139, 1, 16979.7, 8.624, 3.156, 1.763, 81.853, 3.18),
(40, 169, 1, 8379.48, 8.033, 3.247, 1.558, 83.313, 9.28);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `annee`
--
ALTER TABLE `annee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pays_donnees`
--
ALTER TABLE `pays_donnees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_pays` (`id_pays`),
  ADD KEY `id_annee` (`id_annee`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `annee`
--
ALTER TABLE `annee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=327;
--
-- AUTO_INCREMENT pour la table `pays_donnees`
--
ALTER TABLE `pays_donnees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `pays_donnees`
--
ALTER TABLE `pays_donnees`
  ADD CONSTRAINT `pays_donnees_ibfk_1` FOREIGN KEY (`id_pays`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `pays_donnees_ibfk_2` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
