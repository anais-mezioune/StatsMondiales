-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 20 Novembre 2016 à 04:16
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `statsmondiales`
--

-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annee` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=34 ;

--
-- Vider la table avant d'insérer `annee`
--

TRUNCATE TABLE `annee`;
--
-- Contenu de la table `annee`
--

INSERT INTO `annee` (`id`, `annee`) VALUES
(32, 2016),
(33, 2015);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

DROP TABLE IF EXISTS `pays`;
CREATE TABLE IF NOT EXISTS `pays` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=195 ;

--
-- Vider la table avant d'insérer `pays`
--

TRUNCATE TABLE `pays`;
--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id`, `nom`) VALUES
(3, 'Albanie'),
(5, 'Allemagne'),
(13, 'Autriche'),
(19, 'Belgique'),
(23, 'Biélorussie'),
(26, 'Bosnie-Herzégovine'),
(30, 'Bulgarie'),
(50, 'Croatie'),
(52, 'Danemark'),
(58, 'Espagne'),
(59, 'Estonie'),
(63, 'Finlande'),
(64, 'France'),
(69, 'Grèce'),
(78, 'Hongrie'),
(83, 'Irlande'),
(84, 'Islande'),
(86, 'Italie'),
(97, 'Lettonie'),
(102, 'Lituanie'),
(103, 'Luxembourg'),
(104, 'Macédoine'),
(110, 'Malte'),
(117, 'Moldavie'),
(120, 'Montenegro'),
(129, 'Norvège'),
(139, 'Pays-Bas'),
(142, 'Pologne'),
(143, 'Portugal'),
(145, 'Roumanie'),
(146, 'Royaume-Uni'),
(147, 'Russie'),
(158, 'Serbie'),
(162, 'Slovaquie'),
(163, 'Slovénie'),
(168, 'Suède'),
(169, 'Suisse'),
(176, 'République tchèque'),
(186, 'Ukraine');

-- --------------------------------------------------------

--
-- Structure de la table `pays_donnees`
--

DROP TABLE IF EXISTS `pays_donnees`;
CREATE TABLE IF NOT EXISTS `pays_donnees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pays` int(11) NOT NULL,
  `id_annee` int(11) NOT NULL,
  `population` double NOT NULL,
  `mortalite` double NOT NULL,
  `mortalite_infantile` double NOT NULL,
  `natalite` double NOT NULL,
  `esperance_vie` double NOT NULL,
  `croissance` double NOT NULL,
  `annee_id` bigint(20) DEFAULT NULL,
  `pays_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pays` (`id_pays`),
  KEY `id_annee` (`id_annee`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=104 ;

--
-- Vider la table avant d'insérer `pays_donnees`
--

TRUNCATE TABLE `pays_donnees`;
--
-- Contenu de la table `pays_donnees`
--

INSERT INTO `pays_donnees` (`id`, `id_pays`, `id_annee`, `population`, `mortalite`, `mortalite_infantile`, `natalite`, `esperance_vie`, `croissance`, `annee_id`, `pays_id`) VALUES
(2, 23, 32, 9481.520000000004, 14.388, 3.564, 1.633, 71.574, -1.97, NULL, NULL),
(3, 30, 32, 7097.800000000003, 15.458, 8.383, 1.571, 74.419, -7.36, NULL, NULL),
(4, 78, 32, 9821.32, 13.339, 4.291, 1.379, 75.433, -3.42, NULL, NULL),
(5, 117, 32, 4062.8600000000006, 11.462, 9.919, 1.241, 71.813, -1.76, NULL, NULL),
(6, 142, 32, 38593.2, 10.158, 4.116, 1.34, 77.786, -0.62, NULL, NULL),
(7, 145, 32, 19372.699999999997, 13.427, 8.683, 1.517, 74.963, -7.07, NULL, NULL),
(8, 147, 32, 143440, 14.043, 7.523, 1.713, 70.368, -0.29, NULL, NULL),
(9, 162, 32, 5429.419999999998, 10.075, 4.47, 1.417, 76.534, 0.54, NULL, NULL),
(10, 176, 32, 10548.099999999999, 10.396, 2.193, 1.507, 78.923, 0.57, NULL, NULL),
(11, 186, 32, 44624.399999999994, 15.458, 8.418, 1.539, 71.209, -4.69, NULL, NULL),
(12, 52, 32, 5690.75, 9.584, 3.515, 1.741, 80.561, 3.76, NULL, NULL),
(13, 59, 32, 1309.0999999999985, 12.342, 2.892, 1.627, 77.143, -2.6, NULL, NULL),
(14, 63, 32, 5523.9000000000015, 9.784, 1.97, 1.753, 81.196, 3.42, NULL, NULL),
(15, 83, 32, 4713.989999999998, 6.473, 2.544, 2.004, 81.24, 6.43, NULL, NULL),
(16, 84, 32, 331.7779999999984, 6.416, 1.851, 1.91, 82.891, 7.35, NULL, NULL),
(17, 97, 32, 1955.7400000000016, 15.066, 5.78, 1.525, 74.445, -6.63, NULL, NULL),
(18, 102, 32, 2850.029999999999, 15.969, 3.193, 1.622, 73.622, -8.38, NULL, NULL),
(19, 129, 32, 5271.959999999999, 8.065, 2.23, 1.799, 81.868, 11.37, NULL, NULL),
(20, 146, 32, 65111.100000000006, 9.109, 3.757, 1.913, 81.007, 6.11, NULL, NULL),
(21, 168, 32, 9851.849999999999, 9.133, 2.579, 1.926, 82.514, 7.17, NULL, NULL),
(22, 3, 32, 2903.699999999997, 7.57, 13.195, 1.792, 78.156, 2.54, NULL, NULL),
(23, 26, 32, 3802.1300000000047, 10.847, 6.764, 1.243, 76.787, -2.32, NULL, NULL),
(24, 50, 32, 4225, 12.666, 3.379, 1.491, 77.671, -3.61, NULL, NULL),
(25, 58, 32, 46064.600000000006, 9.047, 2.64, 1.355, 82.95, -0.56, NULL, NULL),
(26, 69, 32, 10919.5, 11.05, 2.43, 1.306, 81.267, -2.82, NULL, NULL),
(27, 86, 32, 59801, 10.014, 1.974, 1.468, 83.518, 0, NULL, NULL),
(28, 104, 32, 2081.010000000002, 9.588, 8.96, 1.543, 75.685, 1.17, NULL, NULL),
(29, 110, 32, 419.61499999999796, 9.095, 4.239, 1.472, 80.9, 2.21, NULL, NULL),
(30, 120, 32, 626.1010000000024, 10.129, 3.538, 1.665, 76.515, 0.37, NULL, NULL),
(31, 143, 32, 10304.400000000001, 10.58, 2.844, 1.246, 81.417, -4.12, NULL, NULL),
(32, 158, 32, 8812.71, 12.967, 8.668, 1.584, 75.188, -4.2, NULL, NULL),
(33, 163, 32, 2069.3600000000006, 9.795, 2.809, 1.635, 80.752, 0.9, NULL, NULL),
(34, 5, 32, 80682.4, 11.138, 2.719, 1.422, 81.27, -0.32, NULL, NULL),
(35, 13, 32, 8569.629999999997, 9.432, 2.664, 1.51, 81.777, 2.79, NULL, NULL),
(36, 19, 32, 11371.900000000001, 9.765, 2.938, 1.826, 81.165, 6.36, NULL, NULL),
(37, 64, 32, 64668.100000000006, 9.034, 2.952, 1.995, 82.552, 4.2, NULL, NULL),
(38, 103, 32, 576.2430000000022, 7.157, 1.341, 1.592, 82.074, 14.76, NULL, NULL),
(39, 139, 32, 16979.699999999997, 8.624, 3.156, 1.763, 81.853, 3.18, NULL, NULL),
(40, 169, 32, 8379.479999999996, 8.033, 3.247, 1.558, 83.313, 9.28, NULL, NULL),
(41, 23, 33, 24481.520000000004, 14.388, 3.564, 0, 71.574, -1.97, NULL, NULL),
(42, 30, 33, 22097.800000000003, 15.458, 8.383, 0, 74.419, -7.36, NULL, NULL),
(43, 78, 33, 24821.32, 13.339, 4.291, 0, 75.433, -3.42, NULL, NULL),
(44, 117, 33, 19062.86, 11.462, 9.919, 0, 71.813, -1.76, NULL, NULL),
(45, 142, 33, 53593.2, 10.158, 4.116, 0, 77.786, -0.62, NULL, NULL),
(46, 145, 33, 34372.7, 13.427, 8.683, 0, 74.963, -7.07, NULL, NULL),
(47, 147, 33, 158440, 14.043, 7.523, 0, 70.368, -0.29, NULL, NULL),
(48, 162, 33, 20429.42, 10.075, 4.47, 0, 76.534, 0.54, NULL, NULL),
(49, 176, 33, 25548.1, 10.396, 2.193, 0, 78.923, 0.57, NULL, NULL),
(50, 186, 33, 59624.399999999994, 15.458, 8.418, 0, 71.209, -4.69, NULL, NULL),
(51, 52, 33, 20690.75, 9.584, 3.515, 0, 80.561, 3.76, NULL, NULL),
(52, 59, 33, 16309.099999999999, 12.342, 2.892, 0, 77.143, -2.6, NULL, NULL),
(53, 63, 33, 20523.9, 9.784, 1.97, 0, 81.196, 3.42, NULL, NULL),
(54, 83, 33, 19713.989999999998, 6.473, 2.544, 0, 81.24, 6.43, NULL, NULL),
(55, 84, 33, 15331.777999999998, 6.416, 1.851, 0, 82.891, 7.35, NULL, NULL),
(56, 97, 33, 16955.74, 15.066, 5.78, 0, 74.445, -6.63, NULL, NULL),
(57, 102, 33, 17850.03, 15.969, 3.193, 0, 73.622, -8.38, NULL, NULL),
(58, 129, 33, 20271.96, 8.065, 2.23, 0, 81.868, 11.37, NULL, NULL),
(59, 146, 33, 80111.1, 9.109, 3.757, 0, 81.007, 6.11, NULL, NULL),
(60, 168, 33, 24851.85, 9.133, 2.579, 0, 82.514, 7.17, NULL, NULL),
(61, 3, 33, 17903.699999999997, 7.57, 13.195, 0, 78.156, 2.54, NULL, NULL),
(62, 26, 33, 18802.130000000005, 10.847, 6.764, 0, 76.787, -2.32, NULL, NULL),
(63, 50, 33, 19225, 12.666, 3.379, 0, 77.671, -3.61, NULL, NULL),
(64, 58, 33, 61064.600000000006, 9.047, 2.64, 0, 82.95, -0.56, NULL, NULL),
(65, 69, 33, 25919.5, 11.05, 2.43, 0, 81.267, -2.82, NULL, NULL),
(66, 86, 33, 74801, 10.014, 1.974, 0, 83.518, 0, NULL, NULL),
(67, 104, 33, 17081.010000000002, 9.588, 8.96, 0, 75.685, 1.17, NULL, NULL),
(68, 110, 33, 15419.614999999998, 9.095, 4.239, 0, 80.9, 2.21, NULL, NULL),
(69, 120, 33, 15626.101000000002, 10.129, 3.538, 0, 76.515, 0.37, NULL, NULL),
(70, 143, 33, 25304.4, 10.58, 2.844, 0, 81.417, -4.12, NULL, NULL),
(71, 158, 33, 23812.71, 12.967, 8.668, 0, 75.188, -4.2, NULL, NULL),
(72, 163, 33, 17069.36, 9.795, 2.809, 0, 80.752, 0.9, NULL, NULL),
(73, 5, 33, 95682.4, 11.138, 2.719, 0, 81.27, -0.32, NULL, NULL),
(74, 13, 33, 23569.629999999997, 9.432, 2.664, 0, 81.777, 2.79, NULL, NULL),
(75, 19, 33, 26371.9, 9.765, 2.938, 0, 81.165, 6.36, NULL, NULL),
(76, 64, 33, 79668.1, 9.034, 2.952, 0, 82.552, 4.2, NULL, NULL),
(77, 103, 33, 15576.243000000002, 7.157, 1.341, 0, 82.074, 14.76, NULL, NULL),
(78, 139, 33, 31979.699999999997, 8.624, 3.156, 0, 81.853, 3.18, NULL, NULL),
(79, 169, 33, 23379.479999999996, 8.033, 3.247, 0, 83.313, 9.28, NULL, NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `pays_donnees`
--
ALTER TABLE `pays_donnees`
  ADD CONSTRAINT `pays_donnees_ibfk_5` FOREIGN KEY (`id_pays`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `pays_donnees_ibfk_1` FOREIGN KEY (`id_pays`) REFERENCES `pays` (`id`),
  ADD CONSTRAINT `pays_donnees_ibfk_2` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`),
  ADD CONSTRAINT `pays_donnees_ibfk_3` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`),
  ADD CONSTRAINT `pays_donnees_ibfk_4` FOREIGN KEY (`id_pays`) REFERENCES `pays` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
